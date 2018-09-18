package org.yray.studio.portal.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseService {
    protected Logger _log =null ;     // 这里就不能声明成静态的了，因为很多子类在使用，一定不能使用静态
    public BaseService(){
        _log=LogManager.getLogger(this.getClass().getName());
    }

}
