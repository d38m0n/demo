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


    public ItemService(ItemEntityRepository itemRepository) {
        this.itemRepository = itemRepository;
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

    public ItemReadModel getItemModelById(String id) {
        ModelMapper modelMapper = new ModelMapper();
        ItemEntity itemEntity = getItemEntityById(id);
        return modelMapper.map(itemEntity, ItemReadModel.class);
    }

    public ItemEntity getItemEntityById(String id) {
        return itemRepository.findById(id)
                .orElseThrow(ItemNotFoundIdException::new);
    }

    public void deleteItemById(String idItem) {
        if(!itemRepository.existsById(idItem)) throw new ItemNotFoundIdException();
        itemRepository.deleteById(idItem);
    }
}
