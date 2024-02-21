package service;

import entity.Client;
import entity.Email;
import exception.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import repository.EmailRepository;
import repository.TelephoneRepository;

import java.util.Collection;
@AllArgsConstructor
@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final EmailRepository emailRepository;
    @Autowired
    private final TelephoneRepository telephoneRepository;


    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Long id, @NotNull Client client) {
        Client existingClient = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        existingClient.setName(client.getName());
        return clientRepository.save(client);
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    public Collection<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client remove(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        clientRepository.delete(client);
        return client;
    }
//    public Collection<Email>
}
