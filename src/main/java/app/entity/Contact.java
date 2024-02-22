package app.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class Contact {
    @Id
    private Long contactId;
    private String value;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    public abstract String getContact();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId) && Objects.equals(value, contact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, value);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", value='" + value + '\'' +
                '}';
    }
}
