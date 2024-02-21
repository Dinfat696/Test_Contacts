package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

public class Telephone {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnore
    private Client client;
    public Telephone(){

    }

    public Telephone(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telephone)) return false;
        Telephone telephone = (Telephone) o;
        return Objects.equals(id, telephone.id) && Objects.equals(number, telephone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
