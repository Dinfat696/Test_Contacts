package app.controller;

import app.dto.ClientDto;
import app.dto.ClientHaveContactDto;
import app.dto.ContactDto;
import app.filtered.ClientFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.service.ClientService;

import java.util.Collection;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(service.createClient(clientDto));
    }
    @PostMapping("/{id}/contacts")
    public ResponseEntity<ContactDto> createContact(@PathVariable("id") Long id,@Valid @RequestBody ContactDto contact) {
        return ResponseEntity.ok(service.createContact(id, contact));
    }
    @GetMapping
    public ResponseEntity<Page<ClientDto>> findClients(ClientFilter filter, Pageable pageable) {
        return ResponseEntity.ok(service.findClients(filter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientHaveContactDto> findClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findClient(id));
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<Collection<ContactDto>> findClientContacts(@PathVariable("id") Long id,
                                                                     @RequestParam(value = "type", required = false) String type) {
        return ResponseEntity.ok(service.findClientContacts(id, type));
    }
}
