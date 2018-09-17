package org.yray.studio.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        System.out.println("index");
        return "main/index";
    }
    @RequestMapping(value = "/about" , method = RequestMethod.GET)
    public String about(){

        return "main/about";
    }

    @RequestMapping(value = "/news" , method = RequestMethod.GET)
    public String news(){

        return "main/news";
    }
    @RequestMapping(value = "/account" , method = RequestMethod.GET)
    public String account(){

        return "main/account";
    }
    @RequestMapping(value = "/contact" , method = RequestMethod.GET)
    public String contact(){

        return "main/contact";
    }
    @RequestMapping(value = "/services" , method = RequestMethod.GET)
    public String services(){

        return "main/services";
    }
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){

        return "main/login";
    }
    @RequestMapping(value = "/registration" , method = RequestMethod.GET)
    public String registration(){

        return "main/registration";
    }

    @RequestMapping(value = "/doc" , method = RequestMethod.GET)
    public String doc(){

        return "main/doc";
    }
}
