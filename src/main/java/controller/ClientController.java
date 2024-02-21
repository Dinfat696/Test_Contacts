package controller;

import entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.Collection;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService service;

    @PostMapping
    public Client create(@RequestBody Client client) {
        return service.create(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
       return service.update(id, client);
    }
    @DeleteMapping("/{id}")
    public Client delete(@PathVariable Long id) {
        return service.remove(id);
    }
    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping()
    public Collection<Client> getAll() {
        return service.getAll();
    }
}
