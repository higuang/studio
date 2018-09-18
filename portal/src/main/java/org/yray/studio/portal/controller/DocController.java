package org.yray.studio.portal.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.yray.studio.portal.biz.AttchDtoBiz;
import org.yray.studio.portal.biz.MainDocDtoBiz;
import org.yray.studio.portal.constant.ContentType;
import org.yray.studio.portal.dto.AttchDto;
import org.yray.studio.portal.dto.MainDocDto;
import org.yray.studio.portal.service.IndexerService;
import org.yray.studio.portal.service.MainDocDtoService;
import  org.yray.utils.dcs.DCSUtils;
import org.yray.utils.httpclient.HttpClientUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "/doc")
public class DocController extends  BaseController{

    private  static String baseUrl="http://localhost:8080/portal/doc/res.html";
    @Autowired
    MainDocDtoBiz mainDocDtoBiz;
    @Autowired
    MainDocDtoService mainDocDtoService;
    @Autowired
    IndexerService indexerService;
    @Autowired
    AttchDtoBiz attchDtoBiz;
    @RequestMapping(value = "/index" , method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String index() throws HttpException {
        String out=null;
        String convertByFile = DCSUtils.SubmitPost("http://dcs.yozosoft.com:80/upload", "C:\\Users\\Administrator\\Desktop\\中钞海思发布新版本步骤.docx", "1");
        JSONObject json=JSONObject.parseObject(convertByFile);
        JSONArray data=json.getJSONArray("data");
        String url=data.get(0).toString();
        String html= HttpClientUtil.executGet(url,"UTF-8");
        Document doc = Jsoup.parse(html);
        Elements page=doc.getElementsByClass("word-page");
        String body= page.first().html().replaceAll("\\n","");
        System.out.println(body);
        return html.replaceAll("\\r\\n","");
    }

    @RequestMapping(value = "/doc" , method = RequestMethod.GET)
    public void doc(ModelMap modelMap,HttpServletRequest request, HttpServletResponse resp
            , @RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "fileName", required = false) String fileName
            , @RequestParam(value = "keyword", required = false) String keyword) throws HttpException {
        MainDocDto docDto= null;
        modelMap.put("keyword",keyword);
        if(id!=null)
        {
            docDto= mainDocDtoBiz.selectById(id);
        }
        else
        {
            MainDocDto search=new MainDocDto();
            search.setTitle(fileName);
            docDto= mainDocDtoBiz.selectOne(search);
        }
        if(docDto==null)
        {
            writeResponse(id,resp,"查无此文件","UTF-8");
            return ;
        }
        String html= null;
        String code="UTF-8";
        try {

            String fileType= docDto.getFileType();
            if(fileType.equals("doc")||fileType.equals("docx"))
            {
                fileType="html";
                AttchDto search=new AttchDto();
                search.setMainId(id);
                List<AttchDto> list= attchDtoBiz.selectList(search);
                html = new String(docDto.getContent(),"UTF-8");
                for(AttchDto attchDto:list)
                {
                    if(attchDto.getFileType().equals("files"))
                    {
                        continue;
                    }
                    html= html.replaceFirst(attchDto.getFileName(),baseUrl+"?id="+attchDto.getId());
                }
            }
           else if(fileType.equals("txt"))
            {
                StringBuffer sb=new StringBuffer();
                String content=new String(docDto.getContent(),"GBK");
                content=content.replaceAll("\\r\\n","<br/>");
                sb.append("<!DOCTYPE HTML>\n<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n</head><body>");
                sb.append(content);
                sb.append("</body></html>");
                html=sb.toString();
            }
            resp.setContentType(ContentType.contentTypeMap.get(".html"));
        } catch (Exception e) {
            _log.error(e.getMessage());
        }

        writeResponse(id,resp,html,code);
    }

    @RequestMapping(value = "/res" , method = RequestMethod.GET)
    public void res(HttpServletResponse resp,@RequestParam(value = "id", required = true) String id) throws HttpException {
        AttchDto docDto= attchDtoBiz.selectById(id);
        if(docDto==null)
        {
            return;
        }
        String html= null;
        try {
            html = new String(docDto.getContent(),"UTF-8");
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        resp.setContentType(ContentType.contentTypeMap.get("."+docDto.getFileType()));
        writeResponse(id,resp,docDto.getContent());
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public String list(ModelMap modelMap, @RequestParam(value = "keyword", required = false) String keyword) throws HttpException {

        List<MainDocDto> list=null;
        if(keyword!=null&&!"".equals(keyword))
        {
            list= indexerService.searchMainDoc(keyword);
        }
        if(CollectionUtils.isEmpty(list))
        {
            list=mainDocDtoBiz.selectListAll();
        }
        modelMap.put("list",list);
        modelMap.put("keyword",keyword);
        return  "doc/list";
    }

    @RequestMapping(value = "/tool" , method = RequestMethod.GET)
    public String tool(){

        return "doc/tool";
    }

    @RequestMapping(value = "/reIndex" , method = RequestMethod.GET)
    public String reIndex(){
        long start = System.currentTimeMillis();
        try {
            indexerService.index();
        } catch (Exception e) {
            _log.error("重建索引出错"+e.getMessage());
        } finally {

        }
        return "doc/tool";
    }
    @RequestMapping(value = "/reCreateDate" , method = RequestMethod.GET)
    public String reCreateDate(){
        long start = System.currentTimeMillis();
        try {
            mainDocDtoService.initDoc();
        } catch (Exception e) {
            _log.error("重建文档出错"+e.getMessage());
        } finally {

        }
        return "doc/tool";
    }
}
