package com.example.task.controller;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.NotFoundException;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Detector;
import com.example.task.service.DetectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/detector")
@Api(tags = "detector", description = "Операции над обьектом датчик")
public class DetectorController {
    private final DetectorService service;

    @Autowired
    public DetectorController(final DetectorService service) {
        this.service = service;
    }

    @ApiOperation(value = "Возвращает обьект Detector по этому id")
    @GetMapping(value = "{id}")
    public Optional<Detector> getFactory(@PathVariable Long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Сохраняет обьект Detector")
    @PostMapping()
    public Detector save(@RequestBody SaveObject request) {
        return service.save(request);
    }

    @ApiOperation(value = "Удаляет обьект Detector по указанному id")
    @DeleteMapping(value = "{id}")
    public void deletePreset(@PathVariable("id") Long id) {
        try {
            service.delete(id);
        } catch (RecordNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
