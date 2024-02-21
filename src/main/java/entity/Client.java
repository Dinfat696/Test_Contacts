package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    public Client(){

    };

//    @OneToMany(mappedBy = "client")
//    @JsonIgnore
    private Collection<Email>email;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Collection<Telephone> telephone;

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Email> getEmail() {
        return email;
    }

    public void setEmail(Collection<Email> email) {
        this.email = email;
    }

    public Collection<Telephone> getTelephone() {
        return telephone;
    }

    public void setTelephone(Collection<Telephone> telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

