package com.example.demo.service;

import com.example.demo.entity.ItemEntity;
import com.example.demo.exception.error.ItemNotFoundIdException;
import com.example.demo.exception.error.ItemSNExistException;
import com.example.demo.exception.error.ItemSNRequiredException;
import com.example.demo.model.ItemReadModel;
import com.example.demo.repository.ItemEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {
    private ItemEntityRepository itemRepository;
    private ModelMapper modelMapper;

    public ItemService(ItemEntityRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.modelMapper = new ModelMapper();
    }

    public void addNewItemEntity(ItemEntity source) {
        if (source.getSn() == null) {
            throw new ItemSNRequiredException();
        } else if (itemRepository.existsBySn(source.getSn())) {
            throw new ItemSNExistException();
        } else {
            itemRepository.save(source);
        }
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemReadModel getItemById(String id) {
        return modelMapper.map(itemRepository.findById(id)
                .orElseThrow(ItemNotFoundIdException::new), ItemReadModel.class);
    }
}
