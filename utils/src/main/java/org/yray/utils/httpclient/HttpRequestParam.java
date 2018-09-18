package org.yray.utils.httpclient;

/*
 * http请求键值对
 */
public class HttpRequestParam {
	
	private String paraName;
	
	private String paraValue;

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getParaValue() {
		return paraValue;
	}

	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}
	public HttpRequestParam()
	{
		
	}
	public HttpRequestParam(String key,String value)
	{
		this.paraName=key;
		this.paraValue=value;
	}
}
