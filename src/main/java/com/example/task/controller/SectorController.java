package com.example.task.controller;

import com.example.task.controller.data.SaveObject;
import com.example.task.exceptions.NotFoundException;
import com.example.task.exceptions.RecordNotFoundException;
import com.example.task.models.Sector;
import com.example.task.service.SectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sector")
@Api(tags = "sector", description = "Операции над обьектом участок/цех")
public class SectorController {
    private final SectorService service;

    @Autowired
    public SectorController(final SectorService service) {
        this.service = service;
    }

    @ApiOperation(value = "Возвращает обьект Sector по этому id")
    @GetMapping(value = "{id}")
    public Optional<Sector> getSFactory(@PathVariable Long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Сохраняет обьект Sector")
    @PostMapping()
    public Sector save(@RequestBody SaveObject request) {
        return service.save(request);
    }

    @ApiOperation(value = "Удаляет обьект Sector по указанному id")
    @DeleteMapping(value = "{id}")
    public void deletePreset(@PathVariable("id") Long id) {
        try {
            service.delete(id);
        } catch (RecordNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
