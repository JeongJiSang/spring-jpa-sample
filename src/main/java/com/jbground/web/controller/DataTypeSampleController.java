package com.jbground.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbground.web.model.Order;
import com.jbground.web.service.OrderService;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DataTypeSampleController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/datatype/main.do")
    public String main(){

        return "thymeleaf/jbground/type_sample";
    }

    /**
     * dataType : xml
     */
    @RequestMapping(value = "/datatype/sample1.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample1(HttpServletRequest request, ModelMap model){
        Document document = orderService.getOrderListXml();

        XMLOutputter xmlOut = new XMLOutputter();

        return xmlOut.outputString(document);
    }

    /**
     * dataType : json
     * 방법 1 : @RequestMapping과 @ResponseBody를 이용하여 HTTP통신(JSON형식)을 하는 것
     * <p>
     * 방법 2 : 컨트롤러로 JSON객체를 전송하기 가장 쉬운 방법으로 @RestController를 사용하는 것
     * (@RestController는 @Controller와 @ResponseBody가 합쳐진 것이라고 보면 됨)
     * 방법 3 : 직접 JOSN 객체를 만들어 보내기
     */
    @RequestMapping(value = "/datatype/sample2.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        JSONObject root = orderService.getOrderListJson();
        List<Order> or = orderService.getOrderList();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(or);
        //
        return s;
    }

//    /**
//     * dataType : json
//     */
//    @GetMapping(value = "/datatype/sample2.ajax")
//    public JSONArray sample2_array(HttpServletRequest request, ModelMap model){
//
//        List<Order> orderList = orderService.getOrderList();
//        JSONArray array = new JSONArray();
//
//        for (Order order : orderList) {
//            array.put(String.valueOf(order.getId()));
//            array.put(order.getTitle());
//            array.put(order.getDesc());
//
//        }
//        return array;
//    }

    /**
     * dataType : html
     */
    @RequestMapping(value = "/datatype/sample3.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample3(HttpServletRequest request, ModelMap model){
        return "thymeleaf/jbground/type_sample :: #test";
    }

    /**
     * dataType : script
     */
    @RequestMapping(value = "/datatype/sample4.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample4(HttpServletRequest request, ModelMap model){

        List<Order> orderList = orderService.getOrderList();


        return "";
    }

    /**
     * dataType : jsonp
     */
    @RequestMapping(value = "/datatype/sample5.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample5(HttpServletRequest request, ModelMap model){
        String jsonpCallBack = request.getParameter("jsonpCallBack");
        String str = jsonpCallBack + "( {\"result\":\"ok\"} )";
        return str;
    }

    /**
     * dataType : text
     */
    @RequestMapping(value = "/datatype/sample6.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample6(HttpServletRequest request, ModelMap model){
        List<Order> orderList = orderService.getOrderList();

        return orderList.toString();
    }
}
