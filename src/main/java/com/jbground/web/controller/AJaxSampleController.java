package com.jbground.web.controller;

import com.jbground.web.model.User;
import com.jbground.web.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AJaxSampleController {

    private static final Logger logger = LoggerFactory.getLogger(AJaxSampleController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("/ajax/main.do")
    public String main(HttpServletRequest request, ModelMap model){

        return "thymeleaf/jbground/ajax_sample";
    }

    /**
     * GET 방식 sample1
     * request parameter로 가져오기
     */
    @RequestMapping(value = "/ajax/sample1.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample1(HttpServletRequest request, ModelMap model){
        logger.info("---------------------HttpServletRequest.getParameter(key)");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String hp = request.getParameter("hp");
        String desc = request.getParameter("desc");

        logger.info("name : {}, age : {}, sex : {}, hp : {}, desc : {}", name, age, sex, hp, desc);
        return "\"result\":\"ok\"";
    }

    /**
     * GET 방식 sample2
     * @RequestParam 적용하기
     */
    @RequestMapping(value = "/ajax/sample2.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample2(@RequestParam String name
                            , @RequestParam String age
                          , @RequestParam String sex
                            , @RequestParam String hp
                            , @RequestParam String desc
                            , HttpServletRequest request, ModelMap model){
        logger.info("-----------------------------------------@RequestParam");
        logger.info("name : {}, age : {}, sex : {}, hp : {}, desc : {}", name, age, sex, hp, desc);
        return "\"result\":\"ok\"";
    }

    /**
     * GET 방식 sample3
     * paramMap 적용하기
     */
    @RequestMapping(value = "/ajax/sample3.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample3(@RequestParam Map<String, String> param, HttpServletRequest request, ModelMap model){
        logger.info("----------------------@RequestParam Map<String, String> param");

        String name = param.get("name");
        String age = param.get("age");
        String sex = param.get("sex");
        String hp = param.get("hp");
        String desc = param.get("desc");

        logger.info("name : {}, age : {}, sex : {}, hp : {}, desc : {}", name, age, sex, hp, desc);

        return "\"result\":\"ok\"";
    }

    /**
     * GET 방식 sample4
     * @ModelAttribute 적용하기
     */
    @RequestMapping(value = "/ajax/sample4.ajax", method = RequestMethod.GET)
    @ResponseBody
    public String sample4(@ModelAttribute User user, HttpServletRequest request, ModelMap model){
        logger.info("-----------------------------------@ModelAttribute User user");

        String name = user.getName();
        String age = user.getAge();
        String sex = user.getSex();
        String hp = user.getHp();
        String desc = user.getDesc();

        logger.info("name : {}, age : {}, sex : {}, hp : {}, desc : {}", name, age, sex, hp, desc);
        return "\"result\":\"ok\"";
    }


    /**
     * POST 방식 sample
     */
    @RequestMapping(value = "/ajax/sample5.ajax", method = RequestMethod.POST)
    @ResponseBody
    public String sample5(@ModelAttribute User user, HttpServletRequest request, ModelMap model){
        String name = request.getParameter("name");

        logger.info("-----------------------------------Post @ModelAttribute User user");
        logger.info(user.toString());

        return "\"result\":\"ok\"";
    }


    @RequestMapping(value = "/ajax/sample7.ajax", method = RequestMethod.POST)
    @ResponseBody
    public String sample7(@ModelAttribute User user, HttpServletRequest request, ModelMap model){
        logger.info("-----------------------------------Form/Submit");
        logger.info(user.toString());
        return "\"result\":\"ok\"";
    }
//
//    /**
//     * DELETE 방식 sample
//     */
//    @DeleteMapping(value = "/ajax/sample3.ajax")
//    public List<Object> sample3(HttpServletRequest request, ModelMap model){
//        List<Object> result = new ArrayList<>();
//
//        return result;
//    }
//
//    /**
//     * PUT 방식 sample
//     */
//    @PutMapping(value = "/ajax/sample4.ajax")
//    public List<Object> sample4(HttpServletRequest request, ModelMap model){
//        List<Object> result = new ArrayList<>();
//
//        return result;
//    }
//
//    /*****************************리턴타입 샘플******************************/
//
//    /**
//     *
//     * @return JSONObject
//     */
//    @GetMapping(value = "/ajax/sample5.ajax")
//    public JSONObject sample5() {
//
//        JSONObject root = new JSONObject();
//        root.put("test", new JSONArray());
//        root.getJSONArray("test").put(123);
//
//
//        return root;
//    }
//
//    /**
//     *
//     * @return JSONArray
//     */
//    @RequestMapping("/ajax/sample6.ajax")
//    @ResponseBody
//    public JSONArray sample6() {
//        JSONArray array = new JSONArray();
//
//        return array;
//    }
//
//    /**
//     *
//     * @return Map<String, String>
//     */
//    @GetMapping(value = "/ajax/sample7.ajax")
//    public Map<String, String> sample7(){
//        Map<String, String> map = new HashMap<>();
//
//        return map;
//    }
//
//    @GetMapping(value = "/ajax/sample8.ajax")
//    public String sample8(){
//        Map<String, String> map = new HashMap<>();
//
//        return map.toString();
//    }

}
