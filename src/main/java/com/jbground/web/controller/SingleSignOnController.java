package com.jbground.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleSignOnController {


//    @RequestMapping(value = "/sso/checkauth")
//    public ModelAndView checkAuthorization(){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name", "checkauth.jsp");
//        mv.setViewName("checkauth");
//        return mv;
//    }
    @RequestMapping(value = "/login")
    public String login(){
        return "idpwLogin";
    }


    @RequestMapping(value = "/sso/checkauth")
    public String checkAuthorization(){
        return "sso/checkauth";
    }

    @RequestMapping(value = "/sso/business")
    public String business(){
        return "business";
    }

}
