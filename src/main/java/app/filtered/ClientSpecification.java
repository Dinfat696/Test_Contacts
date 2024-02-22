package app.filtered;

import app.entity.Client;
import app.entity.Client_;
import app.entity.Contact;
import app.entity.Contact_;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;

import java.util.List;


public class ClientSpecification {
    public static Specification<Client> createClientSpecifications(ClientFilter filter) {
        return clientIdEqualTo(filter.getClientId())
                .and(phoneIn(filter.getTelephone()))
                .and(emailIn(filter.getEmail()));
    }

    public static Specification<Client> clientIdEqualTo(Long clientId) {
        return (root, query, builder) -> {
            if (clientId == null) {
                return null;
            }
            return builder.equal(root.get(String.valueOf(Client_.clientId)), clientId);
        };
    }




    public static Specification<Client> phoneIn(String telephone) {
        return (root, query, builder) -> {
            if (telephone == null) {
                return null;
            }
            Join<Client, Contact> clientPhoneJoin = root.join(String.valueOf(Client_.telephones));
            return clientPhoneJoin.get(String.valueOf(Contact_.value)).in(List.of(telephone));

        };
    }
    public static Specification<Client> emailIn(String email) {
        return (root, query, builder) -> {
            if (email == null) {
                return null;
            }
            Join<Client, Contact> clientEmailJoin = root.join(String.valueOf(Client_.emails));
            return clientEmailJoin.get(String.valueOf(Contact_.value)).in(List.of(email));
        };
    }
}

