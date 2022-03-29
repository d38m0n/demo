package com.example.demo.controller;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/item")
    ResponseEntity<?> addItemEntity(@RequestBody ItemEntity source) {
        itemService.addNewItemEntity(source);
        logger.info("Crated new item :" + source.getName());
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/items")
    ResponseEntity<?> getAllItemsEntity() {
        logger.info("Existed all items in DB");
        return ResponseEntity
                .ok(itemService.getAllItems());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/items/{idItem}")
    ResponseEntity<?> findItemById(@PathVariable String idItem) {
        return ResponseEntity.ok(itemService.getItemById(idItem));
    }

}
