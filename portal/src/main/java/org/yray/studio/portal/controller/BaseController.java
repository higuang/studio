package org.yray.studio.portal.controller;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public class BaseController {
    protected Logger _log =null ;     // 这里就不能声明成静态的了，因为很多子类在使用，一定不能使用静态
    public BaseController(){
        _log= LogManager.getLogger(this.getClass().getName());
    }
    /**
     * 将内容写入响应流
     *
     * @param requestId
     * @param resp
     * @param outStr
     */
    public void writeResponse(String requestId, HttpServletResponse resp, String outStr,String code) {
        try {
            resp.setCharacterEncoding(code);
            resp.getWriter().print(outStr);
            IOUtils.closeQuietly(resp.getWriter());
        } catch (Exception e) {
            _log.error("requestId：{}，响应民生异常，异常原因：{}", requestId, e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 将内容写入响应流
     *
     * @param requestId
     * @param resp
     * @param outStr
     */
    public void writeResponse(String requestId, HttpServletResponse resp, byte[] outStr) {
        try {
            OutputStream stream = resp.getOutputStream();
            stream.write(outStr);
            stream.flush();
            stream.close();
        } catch (Exception e) {
            _log.error("requestId：{}，响应民生异常，异常原因：{}", requestId, e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
