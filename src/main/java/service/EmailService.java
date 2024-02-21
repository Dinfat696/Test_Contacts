package service;

import entity.Client;
import entity.Email;
import exception.ClientNotFoundException;
import exception.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ClientRepository;
import repository.EmailRepository;
import repository.TelephoneRepository;

import java.util.Collection;

public class EmailService {
    @Autowired
    private final ClientRepository clientRepository;
    private final EmailRepository emailRepository;
    private final TelephoneRepository telephoneRepository;

    public EmailService(ClientRepository clientRepository, EmailRepository emailRepository, TelephoneRepository telephoneRepository) {
        this.clientRepository = clientRepository;
        this.emailRepository = emailRepository;
        this.telephoneRepository = telephoneRepository;
    }



    public Email create(Email email) {
        return emailRepository.save(email);
    }

    public Email update(Long id, Email email) {
        Email existingEmail = emailRepository.findById(id).orElseThrow(EmailNotFoundException::new);
        existingEmail.setEmail(email.getEmail());
        return emailRepository.save(email);
    }

    public Email getById(Long id) {
        return emailRepository.findById(id).orElseThrow(EmailNotFoundException::new);
    }
    public Collection<Email> getAll(){
        return emailRepository.findAll();
    }
    public Email remove(Long id){
        Email email=emailRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        emailRepository.delete(email);
        return email;
    }
}
