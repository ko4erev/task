package com.example.task.service;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Detector;
import com.example.task.repository.DetectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DetectorService  implements MainService <Detector> {

    private final DetectorRepository repository;

    @Autowired
    public DetectorService(final DetectorRepository repository) {
        this.repository = repository;
    }

    public Optional<Detector> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Detector save(SaveObject request) {
        Detector newDetector = new Detector();
        newDetector.setName(request.getName());
        newDetector.setAttribute(request.getAttribute());
        newDetector.setIdEquipment(request.getIdParent());
        return repository.save(newDetector);
    }

    @Transactional
    public void delete(Long id) {
        Optional<Detector> existing = repository.findById(id);
        if (existing.isPresent()) {
            repository.deleteById(id);
        } else
            throw new RecordNotFoundException("No such records to delete");
    }
}
