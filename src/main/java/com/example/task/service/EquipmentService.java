package com.example.task.service;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Equipment;
import com.example.task.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EquipmentService implements MainService <Equipment> {

    private final EquipmentRepository repository;

    @Autowired
    public EquipmentService(final EquipmentRepository repository) {
        this.repository = repository;
    }

    public Optional<Equipment> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Equipment save(SaveObject request) {
        Equipment newEquipment = new Equipment();
        newEquipment.setName(request.getName());
        newEquipment.setAttribute(request.getAttribute());
        newEquipment.setIdSector(request.getIdParent());
        return repository.save(newEquipment);
    }

    @Transactional
    public void delete(Long id) {
        Optional<Equipment> existing = repository.findById(id);
        if (existing.isPresent()) {
            repository.deleteById(id);
        } else
            throw new RecordNotFoundException("No such records to delete");
    }
}
