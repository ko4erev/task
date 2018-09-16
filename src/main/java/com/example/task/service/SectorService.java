package com.example.task.service;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Sector;
import com.example.task.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SectorService implements MainService <Sector> {
    private final SectorRepository repository;

    @Autowired
    public SectorService(final SectorRepository repository) {
        this.repository = repository;
    }

    public Optional<Sector> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Sector save(SaveObject request) {
        Sector newSector = new Sector();
        newSector.setName(request.getName());
        newSector.setAttribute(request.getAttribute());
        newSector.setIdFactory(request.getIdParent());
        return repository.save(newSector);
    }

    @Transactional
    public void delete(Long id) {
        Optional<Sector> existing = repository.findById(id);
        if (existing.isPresent()) {
            repository.deleteById(id);
        } else
            throw new RecordNotFoundException("No such records to delete");
    }
}
