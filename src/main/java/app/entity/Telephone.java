package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;


import java.util.Objects;
@Entity
public class Telephone extends Contact{

    @Override
    public String getContact() {
        return ContactType.TELEPHONE.name();
    }
}
