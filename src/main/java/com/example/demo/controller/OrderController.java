package com.example.demo.controller;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/order")
    ResponseEntity<?> addOrderEntity(@RequestBody OrderEntity source) {
        orderService.addNewOrderEntity(source);
        logger.info("Crated new order");
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            path = "/order/{idOrder}/{idItem}")
    ResponseEntity<?> addItemToOrderEntity(@PathVariable String idOrder,
                                           @PathVariable String idItem) {
        orderService.addItemToOrderEntity(idOrder, idItem);
        logger.info("Add item to order");
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/order/{idOrder}/{idItem}")
    ResponseEntity<?> deleteItemWithOrderEntity(@PathVariable String idOrder,
                                                @PathVariable String idItem) {
        orderService.deleteItemWithOrderEntity(idOrder, idItem);
        logger.info("Delete item with order");
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/orders")
    ResponseEntity<?> getAllOrdersEntity() {
        logger.info("Existed all job sheet in DB");
        return ResponseEntity
                .ok(orderService.getAllJobsheets());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/order/{idOrder}")
    ResponseEntity<?> findOrderById(@PathVariable String idOrder) {
        return ResponseEntity
                .ok(orderService.getOrderEntityById(idOrder));
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/order/{idOrder}")
    ResponseEntity<?> deleteJobsheetById(@PathVariable String idOrder) {
        orderService.deleteOrderEntity(idOrder);
        return ResponseEntity
                .ok()
                .build();
    }

}
