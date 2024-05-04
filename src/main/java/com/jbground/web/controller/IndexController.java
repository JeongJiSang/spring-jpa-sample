package com.jbground.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping(value="/index.do")
    public String index(HttpServletRequest request, ModelMap model){

        return "thymeleaf/index";
    }

}
