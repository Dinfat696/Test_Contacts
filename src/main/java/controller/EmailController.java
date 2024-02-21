package controller;

import entity.Client;
import entity.Email;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import service.EmailService;

import java.util.Collection;
@AllArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService service;


    @PostMapping
    public Email create(@RequestBody Email email) {
        return service.create(email);
    }

    @PutMapping("/{id}")
    public Email update(@PathVariable Long id, @RequestBody Email email) {
        return service.update(id, email);
    }
    @DeleteMapping("/{id}")
    public Email delete(@PathVariable Long id) {
        return service.remove(id);
    }
    @GetMapping("/{id}")
    public Email getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping()
    public Collection<Email> getAll() {
        return service.getAll();
    }
}


