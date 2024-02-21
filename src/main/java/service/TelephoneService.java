package service;

import entity.Client;
import entity.Email;
import entity.Telephone;
import exception.ClientNotFoundException;
import exception.TelephoneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ClientRepository;
import repository.EmailRepository;
import repository.TelephoneRepository;

import java.util.Collection;

public class TelephoneService {
    @Autowired
    private final ClientRepository clientRepository;
    private final EmailRepository emailRepository;
    private final TelephoneRepository telephoneRepository;

    public TelephoneService(ClientRepository clientRepository, EmailRepository emailRepository, TelephoneRepository telephoneRepository) {
        this.clientRepository = clientRepository;
        this.emailRepository = emailRepository;
        this.telephoneRepository = telephoneRepository;
    }



    public Telephone telephone (Telephone telephone) {
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
    public Collection<Telephone> getAll(){
        return telephoneRepository.findAll();
    }
    public Telephone remove(Long id){
        Telephone telephone=telephoneRepository.findById(id).orElseThrow(TelephoneNotFoundException::new);
        telephoneRepository.delete(telephone);
        return telephone;
    }
}
