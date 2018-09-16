package com.example.task.controller;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.NotFoundException;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Equipment;
import com.example.task.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/equipment")
@Api(tags = "equipment", description = "Операции над обьектом оборудование")
public class EquipmentController {

    private final EquipmentService service;

    @Autowired
    public EquipmentController(final EquipmentService service) {
        this.service = service;
    }

    @ApiOperation(value = "Возвращает обьект Equipment по этому id")
    @GetMapping(value = "{id}")
    public Optional<Equipment> getFactory(@PathVariable Long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Сохраняет обьект Equipment")
    @PostMapping()
    public Equipment save(@RequestBody SaveObject request) {
        return service.save(request);
    }

    @ApiOperation(value = "Удаляет обьект Equipment по указанному id")
    @DeleteMapping(value = "{id}")
    public void deletePreset(@PathVariable("id") Long id) {
        try {
            service.delete(id);
        } catch (RecordNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
