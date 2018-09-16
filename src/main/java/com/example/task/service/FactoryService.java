package com.example.task.service;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Factory;
import com.example.task.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FactoryService implements MainService <Factory> {
    private final FactoryRepository repository;

    @Autowired
    public FactoryService(final FactoryRepository repository) {
        this.repository = repository;
    }

    public Optional<Factory> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Factory save(SaveObject request) {
        Factory newFactory = new Factory();
        newFactory.setName(request.getName());
        newFactory.setAttribute(request.getAttribute());
        return repository.save(newFactory);
    }

    @Transactional
    public void delete(Long id) {
        Optional<Factory> existing = repository.findById(id);
        if (existing.isPresent()) {
            repository.deleteById(id);
        } else
            throw new RecordNotFoundException("No such records to delete");
    }
}
