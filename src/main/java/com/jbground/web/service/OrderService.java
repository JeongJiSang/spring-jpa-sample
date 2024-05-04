package com.jbground.web.service;

import com.jbground.web.model.Order;
import org.jdom.Document;
import org.jdom.Element;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public List<Order> getOrderList(){
        List<Order> list = new ArrayList<>();
        Order order1 = new Order();
        order1.setId(1111L);
        order1.setTitle("A");
        order1.setDesc("TEST1");
        list.add(order1);

        Order order2 = new Order();
        order2.setId(1112L);
        order2.setTitle("B");
        order2.setDesc("TEST2");
        list.add(order2);

        Order order3 = new Order();
        order3.setId(1113L);
        order3.setTitle("C");
        order3.setDesc("TEST3");
        list.add(order3);

        Order order4 = new Order();
        order4.setId(1114L);
        order4.setTitle("D");
        order4.setDesc("TEST4");
        list.add(order4);

        return list;
    }

    public Document getOrderListXml(){
        List<Order> orderList = getOrderList();
        Document document = new Document();
        Element root=new Element("orderList");
        document.setRootElement(root);

        for (Order order : orderList) {
            Element orderElement = new Element("order");

            Element id = new Element("id");
            id.addContent(String.valueOf(order.getId()));
            orderElement.addContent(id);

            Element title = new Element("title");
            title.addContent(String.valueOf(order.getTitle()));
            orderElement.addContent(title);

            Element desc = new Element("desc");
            desc.addContent(String.valueOf(order.getDesc()));
            orderElement.addContent(desc);

            root.addContent(orderElement);
        }

        return document;
    }

    public JSONObject getOrderListJson(){
        List<Order> orderList = getOrderList();

        JSONObject root = new JSONObject();
        JSONArray id = new JSONArray();
        root.put("id", id);

        JSONArray title = new JSONArray();
        root.put("title", title);

        JSONArray desc = new JSONArray();
        root.put("desc", desc);

        for (Order order : orderList) {
            id.put(String.valueOf(order.getId()));
            title.put(order.getTitle());
            desc.put(order.getDesc());

        }

        JSONObject object = new JSONObject();
        object.put("test", true);

        return object;
    }
}
