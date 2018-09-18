package org.yray.utils.httpclient;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.core.Logger;


public class HttpClientUtil {
	
	// 请求超时时间
	private static int connectionRequestTimeout = 30000;
		
	// 连接超时时间，默认10秒
	private static int socketTimeout = 300000;

	// 传输超时时间，默认30秒
	private static int connectTimeout = 300000;
	


	private static HttpClient httpClient;
	public static String executPost(String url,List<HttpRequestParam> httpPara,Header[] headers,String enCoding) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		try {
			// 创建httppost    
	        HttpPost httppost = new HttpPost(url);
	        httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
	        // 创建参数队列    
	        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	        for (HttpRequestParam httpvar : httpPara) {
	        	 formparams.add(new BasicNameValuePair(httpvar.getParaName(), httpvar.getParaValue())); 
			}
	        UrlEncodedFormEntity uefEntity = null;
			
				uefEntity = new UrlEncodedFormEntity(formparams, enCoding);
				httppost.setHeaders(headers);
				httppost.setEntity(uefEntity);
				CloseableHttpResponse response = httpclient.execute(httppost);
				if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					HttpEntity entity = response.getEntity();  
					return EntityUtils.toString(entity, enCoding);
				}
				throw new HttpException("通信异常");
			} catch (Exception e) {
				throw new HttpException("通信异常"+e.getMessage());
			}finally {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

	}
	private static void enableSSL(HttpClient httpclient){  
		try {  
            SSLContext sslcontext = SSLContext.getInstance("TLS");  
            sslcontext.init(null, new TrustManager[] {truseAllManager}, null);  
            SSLSocketFactory sf = new SSLSocketFactory(sslcontext);  
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
            Scheme https = new Scheme("https", sf, 443); 
            SchemeRegistry schemeRegit = httpclient.getConnectionManager().getSchemeRegistry();
            schemeRegit.register(https);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	private static TrustManager truseAllManager = new X509TrustManager(){  
		   
        public void checkClientTrusted(  
                java.security.cert.X509Certificate[] arg0, String arg1)  
                throws CertificateException {  
              
        }  
  
        public void checkServerTrusted(  
                java.security.cert.X509Certificate[] arg0, String arg1)  
                throws CertificateException {  
              
        }  
  
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
            return null;  
        }  
          
    }; 
	public static String executPost(String url,List<HttpRequestParam> httpPara,String enCoding) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httppost
			HttpPost httppost = new HttpPost(url);
			httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
			// 创建参数队列
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			for (HttpRequestParam httpvar : httpPara) {
				formparams.add(new BasicNameValuePair(httpvar.getParaName(), httpvar.getParaValue()));
			}
			UrlEncodedFormEntity uefEntity = null;

			uefEntity = new UrlEncodedFormEntity(formparams, enCoding);
			httppost.setEntity(uefEntity);

			CloseableHttpResponse response = httpclient.execute(httppost);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, enCoding);
			}

			throw new HttpException("通讯状态非200");
		} catch (Exception e) {
			throw new HttpException("通信异常"+e.getMessage());
		}finally {
			try {
				httpclient.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	public static String executGet(String url,String enCoding) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httppost
			HttpGet httpget = new HttpGet(url);
			httpget.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
			CloseableHttpResponse response = httpclient.execute(httpget);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, enCoding);
			}

			throw new HttpException("通讯状态非200");
		} catch (Exception e) {
			throw new HttpException("通信异常"+e.getMessage());
		}finally {
			try {
				httpclient.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	public static byte[] executGetReturnByte(String url,String enCoding) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httppost
			HttpGet httpget = new HttpGet(url);
			httpget.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
			CloseableHttpResponse response = httpclient.execute(httpget);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				//得到实体
				HttpEntity entity = response.getEntity();

				byte[] data = EntityUtils.toByteArray(entity);
				return  data;
			}
			throw new HttpException("通讯状态非200");
		} catch (Exception e) {
			throw new HttpException("通信异常"+e.getMessage());
		}finally {
			try {
				httpclient.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	public static String executGet(String url,String enCoding,Header header) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httppost
			HttpGet httpget = new HttpGet(url);
			httpget.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
			httpget.addHeader(header);
			CloseableHttpResponse response = httpclient.execute(httpget);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, enCoding);
			}

			throw new HttpException("通讯状态非200");
		} catch (Exception e) {
			throw new HttpException("通信异常"+e.getMessage());
		}finally {
			try {
				httpclient.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	public static String executPost(String url,List<HttpRequestParam> httpPara,String enCoding,Header header) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httppost
			HttpPost httppost = new HttpPost(url);
			httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
			// 创建参数队列
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			StringBuffer content=new StringBuffer();
			for (HttpRequestParam httpvar : httpPara) {
				formparams.add(new BasicNameValuePair(httpvar.getParaName(), httpvar.getParaValue()));
				//content.append(httpvar.getParaName()+"="+httpvar.getParaValue()+"&");
			}
			UrlEncodedFormEntity uefEntity = null;

			uefEntity = new UrlEncodedFormEntity(formparams, enCoding);
			httppost.setEntity(uefEntity);
			httppost.addHeader(header);
			httppost.setHeader("Accept", "application/json");
			//httppost.setHeader("accept", "*/*");
			httppost.setHeader("connection", "Keep-Alive");
			httppost.setHeader("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			HttpResponse  response = httpclient.execute(httppost);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, enCoding);
			}

			throw new HttpException("通讯状态非200");
		} catch (Exception e) {
			throw new HttpException("通信异常"+e.getMessage());
		}finally {
			try {
				httpclient.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
	public static String executSSLPost(String url,List<HttpRequestParam> httpPara,String enCoding) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		try {
			enableSSL(httpclient);
			// 创建httppost    
	        HttpPost httppost = new HttpPost(url);
	        httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
	        // 创建参数队列    
	        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	        for (HttpRequestParam httpvar : httpPara) {
	        	 formparams.add(new BasicNameValuePair(httpvar.getParaName(), httpvar.getParaValue())); 
			}
	        UrlEncodedFormEntity uefEntity = null;
			
				uefEntity = new UrlEncodedFormEntity(formparams, enCoding);
				httppost.setEntity(uefEntity);
				CloseableHttpResponse response = httpclient.execute(httppost);
				if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					HttpEntity entity = response.getEntity();  
					return EntityUtils.toString(entity, enCoding);
				}
				throw new HttpException("通信异常");
			} catch (Exception e) {
				throw new HttpException("通信异常"+e.getMessage());
			}finally {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

	}
		public String executeGet(String url,String enCoding) throws Exception {
			// 定义HttpClient
			CloseableHttpClient client = HttpClients.createDefault(); 
			try {				
				// 实例化HTTP方法
				HttpGet request = new HttpGet(url);
				CloseableHttpResponse response = client.execute(request);
				if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					HttpEntity entity = response.getEntity();  
					return EntityUtils.toString(entity, enCoding);
				}
				throw new HttpException("通信异常");
			} catch (Exception e) {
				throw new HttpException("通信异常"+e.getMessage());
			}finally {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

	}
		public static String executPost(String url,String content,String enCoding) throws HttpException{
			CloseableHttpClient httpclient = HttpClients.createDefault(); 
			try {
				// 创建httppost    
		        HttpPost httppost = new HttpPost(url);
		        httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
						.setSocketTimeout(socketTimeout).build());
					httppost.setEntity(new ByteArrayEntity(content.getBytes(enCoding),ContentType.TEXT_XML));
					CloseableHttpResponse response = httpclient.execute(httppost);
					if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
						HttpEntity entity = response.getEntity();  
						return EntityUtils.toString(entity, enCoding);
					}
					throw new HttpException("通信异常");
				} catch (Exception e) {
					throw new HttpException("通信异常"+e.getMessage());
				}finally {
					try {
						httpclient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

		}
	public static String executPost(String url,String content,String enCoding,ContentType contentType) throws HttpException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httppost
			HttpPost httppost = new HttpPost(url);
			httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build());
			httppost.setEntity(new ByteArrayEntity(content.getBytes(enCoding),contentType));
			CloseableHttpResponse response = httpclient.execute(httppost);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, enCoding);
			}
			throw new HttpException("通信异常");
		} catch (Exception e) {
			throw new HttpException("通信异常"+e.getMessage());
		}finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
		public static String executPost(String url,String content,Header[] headers,String enCoding) throws HttpException{
			CloseableHttpClient httpclient = HttpClients.createDefault(); 
			try {
				// 创建httppost    
		        HttpPost httppost = new HttpPost(url);
		        httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
						.setSocketTimeout(socketTimeout).build());
					httppost.setEntity(new ByteArrayEntity(content.getBytes(enCoding),ContentType.TEXT_PLAIN));
					httppost.setHeaders(headers);
					CloseableHttpResponse response = httpclient.execute(httppost);
					if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
						HttpEntity entity = response.getEntity();  
						return EntityUtils.toString(entity, enCoding);
					}
					throw new HttpException("通信异常");
				} catch (Exception e) {
					throw new HttpException("通信异常"+e.getMessage());
				}finally {
					try {
						httpclient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

		}
		public static String executPosthttps(String url,List<HttpRequestParam> httpPara,String enCoding) throws HttpException{
			if (httpClient == null) {
				httpClient = getHttpClient();
			}
			enableSSL(httpClient) ;
			try {
				// 创建httppost    
		        HttpPost httppost = new HttpPost(url);
		        // 创建参数队列    
		        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		        for (HttpRequestParam httpvar : httpPara) {
		        	 formparams.add(new BasicNameValuePair(httpvar.getParaName(), httpvar.getParaValue())); 
				}
		      
		        httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(socketTimeout).setConnectTimeout(connectTimeout)
						.setSocketTimeout(socketTimeout).build());
		        UrlEncodedFormEntity uefEntity = null;
				
					uefEntity = new UrlEncodedFormEntity(formparams, enCoding);
					httppost.setEntity(uefEntity);
					HttpResponse response = httpClient.execute(httppost);
					int statusCode = response.getStatusLine().getStatusCode();
					if (HttpStatus.SC_OK == statusCode) {
						HttpEntity entity = response.getEntity();
						return EntityUtils.toString(entity, "GBK");
					}
					if (HttpStatus.SC_MOVED_TEMPORARILY == statusCode) {	//重定向
						
					}
					throw new HttpException("通信异常");
				} catch (Exception e) {
					throw new HttpException("通信异常"+e.getMessage());
				}finally {
					/*try {
						httpclient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}*/
				}
		}
		public static String executPosthttps(String url,List<HttpRequestParam> httpPara,String enCoding,String deCoding) throws HttpException{
			if (httpClient == null) {
				httpClient = getHttpClient();
			}
			enableSSL(httpClient) ;
			try {
				// 创建httppost    
		        HttpPost httppost = new HttpPost(url);
		        // 创建参数队列    
		        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		        for (HttpRequestParam httpvar : httpPara) {
		        	 formparams.add(new BasicNameValuePair(httpvar.getParaName(), httpvar.getParaValue())); 
				}
		      
		        httppost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(socketTimeout).setConnectTimeout(connectTimeout)
						.setSocketTimeout(socketTimeout).build());
		        UrlEncodedFormEntity uefEntity = null;
				
					uefEntity = new UrlEncodedFormEntity(formparams, enCoding);
					httppost.setEntity(uefEntity);
					HttpResponse response = httpClient.execute(httppost);
					int statusCode = response.getStatusLine().getStatusCode();
					if (HttpStatus.SC_OK == statusCode) {
						HttpEntity entity = response.getEntity();
						return EntityUtils.toString(entity, deCoding);
					}
					if (HttpStatus.SC_MOVED_TEMPORARILY == statusCode) {	//重定向
						
					}
					throw new HttpException("通信异常");
				} catch (Exception e) {
					throw new HttpException("通信异常"+e.getMessage());
				}finally {
					/*try {
						httpclient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}*/
				}
		}
		private static HttpClient getHttpClient() {
			if (null != httpClient) {
				return httpClient;
			}
			httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager());
			return httpClient;
		}

	public static void main(String[] args) {
		List<HttpRequestParam> httpRequestParam = new ArrayList<HttpRequestParam>();
		HttpRequestParam reqParam = new HttpRequestParam();
		reqParam.setParaName("packet");
		String content = "e3BsYWluOnsgbW9iaWxlOicxMzgwMDEzODAwMCcsIHBvc2l0aW9uOicxMTYuNDgxNDg4LDM5Ljk5MDQ2NCcgICwga2V5czon55uY5bqTJyAsIGFiaWxpdHk6J+mAgeW/q+mAkicsIHBhZ2VOdW06JzEnLCBwYWdlU2l6ZTonMTUnfSwgc2lnbmF0dXJlIDonTVVJNVFVVTJOamN3UkVWR01FRTRNMEUwTUVVNE1qVXdSRUZHUVVJME5qRkVORVZHUmpjMk5BPT0nfQ==";
		reqParam.setParaValue(content);
		httpRequestParam.add(reqParam);
		String retrunMsg = "";
		try {
			//String sendUrl = "http://localhost:8011/mobile/1001";
			//String sendUrl = "http://172.168.102.5:8011/mobile/1001";
			String sendUrl = "http://172.168.102.7:8011/mobile/3001";
			retrunMsg = HttpClientUtil.executPost(sendUrl,httpRequestParam,"GBK");
			System.out.println(retrunMsg);
		} catch (HttpException e) {
			e.printStackTrace();
		}
	}
}
