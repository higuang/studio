package org.yray.studio.portal.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.yray.studio.portal.biz.AttchDtoBiz;
import org.yray.studio.portal.biz.MainDocDtoBiz;
import org.yray.studio.portal.dao.AttchDtoMapper;
import org.yray.studio.portal.dao.MainDocDtoMapper;
import org.yray.studio.portal.dto.AttchDto;
import org.yray.studio.portal.dto.MainDocDto;
import org.yray.utils.dcs.DCSUtils;
import org.yray.utils.file.FileUtils;
import org.yray.utils.httpclient.HttpClientUtil;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class MainDocDtoService extends BaseService {

    @Resource
    AttchDtoBiz attchDtoBiz;
    @Resource
    MainDocDtoBiz mainDocDtoBiz;
    void insert(MainDocDto record)
    {
        mainDocDtoBiz.insert(record);
    }

   public void doDetail(File file)
    {

        try {
            MainDocDto mainDocDto=new MainDocDto();
            mainDocDto.setTitle(file.getName());
            mainDocDto.setId(UuidUtil.getTimeBasedUuid().toString());
            mainDocDto.setCreateTime(new Date());
            mainDocDto.setUpdateTime(new Date());
            if(file.getName().lastIndexOf(".")>-1) {
                mainDocDto.setFileType(FileUtils.getFileType(file.getName()));
            }
            else
            {   mainDocDto.setFileType(file.getName());
                _log.error("fileName["+file.getName());
            }
            mainDocDto.setFileName(file.getAbsolutePath());
            if(mainDocDto.getFileType().equals("doc")||mainDocDto.getFileType().equals("docx"))
            {
                insertDoc(mainDocDto);
            }
            else if(mainDocDto.getFileType().equals("bak"))
            {
                return;
            }
            else
            {
                mainDocDto.setContent(FileUtils.readFileToByteArray(file));
                mainDocDto= mainDocDtoBiz.insertByFileName(mainDocDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public void initDoc()
    {
        String dataDir = "D:\\yray_studio\\yray_doc";
        File[] files = new File(dataDir).listFiles();
        for (File file : files) {
            //索引指定文件
            doDetail(file);
        }
    }

   public void insertDoc(MainDocDto mainDocDto) throws Exception {
        // 文件上传转换
        String convertByFile = DCSUtils.SubmitPost("http://dcs.yozosoft.com:80/upload", mainDocDto.getFileName(), "1");
        JSONObject json=JSONObject.parseObject(convertByFile);
        JSONArray data=json.getJSONArray("data");
        String url=data.get(0).toString();
        String html= null;
        html = HttpClientUtil.executGet(url,"UTF-8");
        mainDocDto.setContent(html.getBytes("UTF-8"));
       mainDocDto= mainDocDtoBiz.insertByFileName(mainDocDto);
        Document doc = Jsoup.parse(html);
        List<String> urlList=new ArrayList<String>();
//        int i= html.indexOf("./");
//        while (i>-1)
//        {
//            urlList.add(html.substring(i,html.indexOf("\"",i+1)));
//            i=html.indexOf("./",i+1);
//        }
        urlList= getUrls(urlList,doc,"img","src");
        urlList= getUrls(urlList,doc,"link","href");
        urlList= getUrls(urlList,doc,"script","src");
        urlList= getUrls(urlList,doc,"IMAGEDATA","src");
       urlList= getUrls(urlList,doc,"v:IMAGEDATA","src");
       AttchDto del=new AttchDto();
       del.setMainId(mainDocDto.getId());
       attchDtoBiz.delete(del);
        for(String attchUrl:urlList)
        {
            if(url.lastIndexOf("/")==-1) {
                _log.error("url["+url);
                continue;
            }
            _log.info("url="+url);
            _log.info("attchUrl="+attchUrl);
            String newUrl=url.substring(0,url.lastIndexOf("/"))+attchUrl.substring(1) ;


            AttchDto attchDto=new AttchDto();
            attchDto.setCreateTime(new Date());
            attchDto.setUpdateTime(new Date());
            attchDto.setId(UuidUtil.getTimeBasedUuid().toString());
            if(newUrl.lastIndexOf(".")==-1) {
                _log.error("newUrl["+newUrl);
                continue;
            }
            attchDto.setFileType( newUrl.substring(newUrl.lastIndexOf(".")+1));
            attchDto.setFileName(attchUrl);
            attchDto.setMainId(mainDocDto.getId());
            if(attchDto.getFileType().equals("css")
                    ||attchDto.getFileType().equals("js")
                    ||attchDto.getFileType().equals("png")
                    ||attchDto.getFileType().equals("jpg")
                    ||attchDto.getFileType().equals("jpeg")
                    ||attchDto.getFileType().equals("gif")) {
                byte[] attchStr = HttpClientUtil.executGetReturnByte(newUrl, "UTF-8");
                attchDto.setContent(attchStr);
            }


            attchDtoBiz.insert(attchDto);

        }
    }
    private  List<String> getUrls(List<String> urlList,Document doc,String tagName,String srcName)
    {
        Elements imgEle=doc.getElementsByTag(tagName);
        Iterator<Element> imgIt=imgEle.iterator();
        while (imgIt.hasNext())
        {
            Element e=imgIt.next();
            String url=e.attr(srcName);
            if(StringUtils.isEmpty(url))
            {
                _log.error("错误,url为空="+e.html());
                continue;
            }
            urlList.add(url) ;
        }
        return  urlList;
    }
}
