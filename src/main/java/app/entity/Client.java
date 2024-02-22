package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Email> email;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Telephone> telephone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                '}';
    }
}


