package app.mapper;

import app.entity.*;
import app.entity.Telephone;
import app.dto.ContactDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor

    public class ContactMapper {
        public Contact toPhone(ContactDto contactDto, Client client) {
            Contact telephone = new Telephone();
            telephone.setClient(client);
            telephone.setValue(contactDto.getValue());
            return telephone;
        }

        public Contact toEmail(ContactDto contactDto, Client client) {
            Contact email = new Email();
            email.setClient(client);
            email.setValue(contactDto.getValue());
            return email;
        }
        public ContactDto toContactDto(Contact contact) {
            ContactDto contactDto = new ContactDto();
            contactDto.setContactId(contact.getContactId());
            contactDto.setContactType(contactDto.getContactType());
            contactDto.setValue(contact.getValue());
            return contactDto;
        }
    }
