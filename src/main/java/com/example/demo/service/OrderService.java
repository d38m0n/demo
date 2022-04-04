package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.exception.error.NotFoundException;
import com.example.demo.repository.OrderEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    private OrderEntityRepository orderRepository;
    private ItemService itemService;


    public OrderService(OrderEntityRepository repository, ItemService itemService) {
        this.orderRepository = repository;
        this.itemService = itemService;
    }

    public void addNewOrderEntity(OrderEntity source) {
        orderRepository.save(source);
    }


    public List<OrderEntity> getAllJobsheets() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderEntityById(String id) {
        return orderRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public void deleteOrderEntity(String idItem) {
        if (!orderRepository.existsById(idItem)) throw new NotFoundException();
        orderRepository.deleteById(idItem);
    }

    public OrderEntity addItemToOrderEntity(String idOrder, String idItem) {
        return orderRepository.save(getOrderEntityById(idOrder)
                .addItem(itemService.getItemEntityById(idItem)));
    }

    public OrderEntity deleteItemWithOrderEntity(String idOrder, String idItem) {
        return orderRepository.save(getOrderEntityById(idOrder)
                .deleteItem(itemService.getItemEntityById(idItem)));
    }
}
