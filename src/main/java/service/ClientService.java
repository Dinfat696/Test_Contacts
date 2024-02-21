package service;

import entity.Client;
import entity.Email;
import exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ClientRepository;
import repository.EmailRepository;
import repository.TelephoneRepository;

import java.util.Collection;

public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    private final EmailRepository emailRepository;
    private final TelephoneRepository telephoneRepository;

    public ClientService(ClientRepository clientRepository, EmailRepository emailRepository, TelephoneRepository telephoneRepository) {
        this.clientRepository = clientRepository;
        this.emailRepository = emailRepository;
        this.telephoneRepository = telephoneRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        existingClient.setName(client.getName());
        return clientRepository.save(client);
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }
    public Collection<Client> getAll(){
        return clientRepository.findAll();
    }
    public Client remove(Long id){
        Client client=clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        clientRepository.delete(client);
        return client;
    }
//    public Collection<Email>
}
