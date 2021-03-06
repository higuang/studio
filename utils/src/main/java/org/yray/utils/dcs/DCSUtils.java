package org.yray.utils.dcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.yray.utils.httpclient.HttpClientUtil;

/**
 * @Description: DCS文档转换服务Java调用代码示例
 * @author LB
 * @date 20151014
 */
public class DCSUtils {
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV 1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 向指定 URL 上传文件POST方法的请求
     *
     * @param url      发送请求的 URL
     * @param filepath 文件路径
     * @param type     转换类型
     * @return 所代表远程资源的响应结果, json数据
     */
    public static String SubmitPost(String url, String filepath, String type) {
        String requestJson = "";
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpPost httppost = new HttpPost(url);
            FileBody file = new FileBody(new File(filepath));
            MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null,
                    Charset.forName("UTF-8"));
            reqEntity.addPart("file", file); // file为请求后台的File upload;属性
            reqEntity.addPart("convertType", new StringBody(type, Charset.forName("UTF-8")));
            httppost.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(httppost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                requestJson = EntityUtils.toString(resEntity);
                EntityUtils.consume(resEntity);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // requestJson = e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // requestJson = e.toString();
        } finally {
            try {
                httpclient.getConnectionManager().shutdown();
            } catch (Exception ignore) {
            }
        }
        return requestJson;
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // 文件上传转换
        String convertByFile = SubmitPost("http://dcs.yozosoft.com:80/upload", "C:\\Users\\Administrator\\Desktop\\中钞海思发布新版本步骤.docx", "1");
        JSONObject json=JSONObject.parseObject(convertByFile);
        JSONArray data=json.getJSONArray("data");
        String url=data.get(0).toString();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(url);
        System.out.println("--------------------------------------------------------------------------");
        String html= HttpClientUtil.executGet(url,"UTF-8");
        Document doc = Jsoup.parse(html);
        List<String> urlList=new ArrayList<String>();
        Elements page=doc.getElementsByClass("word-page");
        urlList= getUrls(urlList,doc,"img","src");
        urlList= getUrls(urlList,doc,"link","href");
        urlList= getUrls(urlList,doc,"script","src");
        urlList= getUrls(urlList,doc,"IMAGEDATA","src");
        System.out.println("------------------------------URL------------------------------------------");
        for(String urlStr:urlList)
        {
            System.out.println(urlStr);
        }
        String body= page.first().html();
        System.out.println("------------------------------HTML-------------------------------------------");
        System.out.println(html);
        System.out.println("--------------------------------------------------------------------------");

       int i= html.indexOf("./");
       while (i>-1)
       {
           System.out.println(html.substring(i,html.indexOf("\"",i+1)));
           i=html.indexOf("./",i+1);

       }

    }

    private static List<String> getUrls(List<String> urlList,Document doc,String tagName,String srcName)
    {
        Elements imgEle=doc.getElementsByTag(tagName);
        Iterator<Element> imgIt=imgEle.iterator();
        while (imgIt.hasNext())
        {
            Element e=imgIt.next();
            urlList.add(e.attr(srcName)) ;
        }
        return  urlList;
    }
}
