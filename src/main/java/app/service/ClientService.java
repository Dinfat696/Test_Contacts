package app.service;

import app.dto.ClientDto;
import app.dto.ClientHaveContactDto;
import app.dto.ContactDto;
import app.entity.Client;
import app.entity.Contact;
import app.entity.ContactType;
import app.exception.ClientNotFoundException;
import app.exception.ContactNotDeterminedException;
import app.exception.ContactNotValidException;
import app.exception.InvalidContactTypeException;
import app.filtered.ClientFilter;
import app.filtered.ClientSpecification;
import app.mapper.ClientMapper;
import app.mapper.ContactMapper;
import app.repository.ClientRepository;
import app.repository.ContactRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final ClientMapper clientMapper;
    private final ContactMapper contactMapper;


    @Transactional
    public ClientDto createClient(ClientDto clientDto) {
        Client client = clientRepository.save(clientMapper.toClient(clientDto));
        return clientMapper.toClientDto(client);
    }

    @Transactional
    public ContactDto createContact(long id, ContactDto contactDto) {
        Client client = getClientOrThrowException(id);
        Contact contact = determineNewContact(contactDto, client);
        contactRepository.save(contact);
        return contactMapper.toContactDto(contact);
    }

    private Contact determineNewContact(ContactDto contactDto, Client client) {
        ContactType contactType = getContactTypeOrThrowException(contactDto.getContactType());
        switch (contactType) {
            case TELEPHONE -> {
                validatePhone(contactDto.getValue());
                return contactMapper.toPhone(contactDto, client);
            }
            case EMAIL -> {
                validateEmail(contactDto.getValue());
                return contactMapper.toEmail(contactDto, client);
            }
        }
        throw new ContactNotDeterminedException("Contact not determined");
    }

    public Page<ClientDto> findClients(ClientFilter filters, Pageable pageable) {
        Specification<Client> specification = ClientSpecification.createClientSpecifications(filters);
        return clientRepository.findAll(specification, pageable).map(clientMapper::toClientDto);
    }

    public ClientHaveContactDto findClient(long id) {
        Client client = getClientOrThrowException(id);
        return clientMapper.toClientHaveContactsDto(client);
    }

    public Collection<ContactDto> findClientContacts(long id, String type) {
        Client client = getClientOrThrowException(id);
        if (type == null) {
            return clientMapper.toContactsList(client);
        }
        ContactType contactType = getContactTypeOrThrowException(type);
        switch (contactType) {
            case TELEPHONE -> {
                return clientMapper.toPhonesList(client);
            }
            case EMAIL -> {
                return clientMapper.toEmailsList(client);
            }
            default -> {
                return clientMapper.toContactsList(client);
            }
        }
    }

    private Client getClientOrThrowException(long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format("Client %s not found", id)));
    }

    private ContactType getContactTypeOrThrowException(String value) {
        return ContactType.valueOf(value);

    }

    private void validatePhone(String phone) {
        String regexPattern = "^((\\+7|7|8)+([0-9]){10})$";
        if (!Pattern.compile(regexPattern).matcher(phone).matches()) {
            throw new ContactNotValidException(String.format("Phone %s is not valid", phone));
        }
    }

    private void validateEmail(String email) {
        String regexPattern = "^(\\S+)@([a-z0-9-]+)(\\.)([a-z]{2,4})(\\.?)([a-z]{0,4})+$";
        if (!Pattern.compile(regexPattern).matcher(email).matches()) {
            throw new ContactNotValidException(String.format("Email %s is not valid", email));
        }
    }
}