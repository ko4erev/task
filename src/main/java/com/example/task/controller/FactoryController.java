package com.example.task.controller;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.NotFoundException;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Factory;
import com.example.task.service.FactoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/factory")
@Api(tags = "factory", description = "Операции над обьектом завод")
public class FactoryController {

    private final FactoryService service;

    @Autowired
    public FactoryController(final FactoryService service) {
        this.service = service;
    }

    @ApiOperation(value = "Возвращает обьект Factory по указанному id")
    @GetMapping(value = "{id}")
    public Optional<Factory> getFactory(@PathVariable Long id) {
        Optional<Factory> result = service.findById(id);
        if (result.isPresent()) {
            return result;
        } else
            throw new NotFoundException("No such object");
    }

    @ApiOperation(value = "Сохраняет обьект Factory")
    @PostMapping()
    public Factory save(@RequestBody SaveObject request) {
        return service.save(request);
    }

    @ApiOperation(value = "Удаляет обьект Factory по указанному id")
    @DeleteMapping(value = "{id}")
    public void deletePreset(@PathVariable("id") Long id) {
        try {
            service.delete(id);
        } catch (RecordNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
