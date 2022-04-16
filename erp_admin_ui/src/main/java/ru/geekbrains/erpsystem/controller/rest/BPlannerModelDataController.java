package ru.geekbrains.erpsystem.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.erpsystem.entities.BPlannerModelData;
import ru.geekbrains.erpsystem.services.BPlannerModelDataService;

import java.util.List;

@RestController
@RequestMapping("/bplannerdata")
public class BPlannerModelDataController {

    private final BPlannerModelDataService service;

    public BPlannerModelDataController(BPlannerModelDataService service) {
        this.service = service;
    }

    @PostMapping(value = "/new", consumes = "application/json")
    public void addNewDataEntry(@RequestBody String data) {
        service.save(new BPlannerModelData(null, data));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BPlannerModelData>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
