package controller;

import entity.Client;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.Collection;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

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
