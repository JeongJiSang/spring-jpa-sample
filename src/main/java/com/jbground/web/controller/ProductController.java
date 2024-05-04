package com.jbground.web.controller;

import com.jbground.web.model.Paging;
import com.jbground.web.model.Product;
import com.jbground.web.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource(type = ProductService.class)
    private ProductService productService;


    @RequestMapping(value = "/product/list2")
    public String productList(HttpServletRequest request, ModelMap model) throws Exception{
        return "thymeleaf/product/product_list2";
    }

    @RequestMapping(value = "/product/pagination", method = RequestMethod.GET)
    @ResponseBody
    public Page<Product> productPagination(@ModelAttribute Paging paging, HttpServletRequest request) throws Exception {
        return productService.getProductListByPage(paging);
    }
}
