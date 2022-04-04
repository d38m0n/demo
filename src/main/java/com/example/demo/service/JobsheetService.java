package com.example.demo.service;

import com.example.demo.entity.JobsheetEntity;
import com.example.demo.exception.error.NotFoundException;
import com.example.demo.repository.JobsheetEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobsheetService {
    private JobsheetEntityRepository jobsheetRepository;
    private ItemService itemService;


    public JobsheetService(JobsheetEntityRepository repository, ItemService itemService) {
        this.jobsheetRepository = repository;
        this.itemService = itemService;
    }

    public void addNewJobsheetEntity(JobsheetEntity source) {
        jobsheetRepository.save(source);
    }


    public List<JobsheetEntity> getAllJobsheets() {
        return jobsheetRepository.findAll();
    }

    public JobsheetEntity getJobsheetById(String id) {
        return jobsheetRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public void deleteJobsheetById(String idItem) {
        if (!jobsheetRepository.existsById(idItem)) throw new NotFoundException();
        jobsheetRepository.deleteById(idItem);
    }

    public JobsheetEntity addItemToJobsheetEntity(String idJobsheet, String idItem) {
        return jobsheetRepository.save(getJobsheetById(idJobsheet)
                .addItem(itemService.getItemEntityById(idItem)));
    }

    public JobsheetEntity deleteItemWithJobsheetEntity(String idJobsheet, String idItem) {
        return jobsheetRepository.save(getJobsheetById(idJobsheet)
                .deleteItem(itemService.getItemEntityById(idItem)));
    }
}
