package service;

import entity.Client;
import entity.Email;
import entity.Telephone;
import exception.ClientNotFoundException;
import exception.TelephoneNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import repository.EmailRepository;
import repository.TelephoneRepository;

import java.util.Collection;
@AllArgsConstructor
@Service
public class TelephoneService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final EmailRepository emailRepository;
    @Autowired
    private final TelephoneRepository telephoneRepository;


    public Telephone telephone(Telephone telephone) {
        return telephoneRepository.save(telephone);
    }

    public Telephone create(Telephone telephone) {
        return telephoneRepository.save(telephone);
    }

    public Telephone update(Long id, Telephone telephone) {
        Telephone existingTelephone = telephoneRepository.findById(id).orElseThrow(TelephoneNotFoundException::new);
        existingTelephone.setNumber(telephone.getNumber());
        return telephoneRepository.save(telephone);
    }

    public Telephone getById(Long id) {
        return telephoneRepository.findById(id).orElseThrow(TelephoneNotFoundException::new);
    }

    public Collection<Telephone> getAll() {
        return telephoneRepository.findAll();
    }

    public Telephone remove(Long id) {
        Telephone telephone = telephoneRepository.findById(id).orElseThrow(TelephoneNotFoundException::new);
        telephoneRepository.delete(telephone);
        return telephone;
    }
}
