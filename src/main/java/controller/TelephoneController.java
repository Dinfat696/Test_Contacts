package controller;

import entity.Client;
import entity.Telephone;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import service.TelephoneService;

import java.util.Collection;

public class TelephoneController {

    private final TelephoneService service;

    public TelephoneController(TelephoneService service) {
        this.service = service;
    }

    @PostMapping
    public Telephone create(@RequestBody Telephone telephone) {
        return service.create(telephone);
    }

    @PutMapping("/{id}")
    public Telephone update(@PathVariable Long id, @RequestBody Telephone telephone) {
        return service.update(id, telephone);
    }
    @DeleteMapping("/{id}")
    public Telephone delete(@PathVariable Long id) {
        return service.remove(id);
    }
    @GetMapping("/{id}")
    public Telephone getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping()
    public Collection<Telephone> getAll() {
        return service.getAll();
    }
}

