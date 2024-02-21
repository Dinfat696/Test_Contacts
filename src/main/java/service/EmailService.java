package service;

import entity.Client;
import entity.Email;
import exception.ClientNotFoundException;
import exception.EmailNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import repository.EmailRepository;
import repository.TelephoneRepository;

import java.util.Collection;
@AllArgsConstructor
@Service
public class EmailService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final EmailRepository emailRepository;
    @Autowired
    private final TelephoneRepository telephoneRepository;


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

    public Collection<Email> getAll() {
        return emailRepository.findAll();
    }

    public Email remove(Long id) {
        Email email = emailRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        emailRepository.delete(email);
        return email;
    }
}
