package app.mapper;

import app.entity.Client;
import app.entity.Contact;
import app.dto.ClientDto;
import app.dto.ClientHaveContactDto;
import app.dto.ContactDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientMapper {
    private final ContactMapper contactMapper;

    public Client toClient(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        return client;
    }

    public ClientDto toClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setName(client.getName());
        return clientDto;
    }
    public ClientHaveContactDto toClientHaveContactsDto(Client client) {
        ClientHaveContactDto clientDto = new ClientHaveContactDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setName(client.getName());
        clientDto.setContacts(toContactsList(client));
        return clientDto;
    }

    public List<ContactDto> toContactsList(Client client) {
        return getContactDtoList(getClientContacts(client));
    }

    public List<ContactDto> toPhonesList(Client client) {
        return getContactDtoList(getClientPhones(client));
    }
    public List<ContactDto> toEmailsList(Client client) {
        return getContactDtoList(getClientEmails(client));
    }

    private List<ContactDto> getContactDtoList(Collection<Contact> contacts) {
        return contacts.stream()
                .map(contactMapper::toContactDto)
                .collect(Collectors.toList());
    }

    private List<Contact> getClientContacts(Client client) {
        List<Contact> contacts = new ArrayList<>(client.getTelephone());
        contacts.addAll(client.getEmail());
        return contacts;
}


    private List<Contact> getClientPhones(Client client) {
        return new ArrayList<>(client.getTelephone());
    }

    private List<Contact> getClientEmails(Client client) {
        return new ArrayList<>(client.getEmail());
    }
}
