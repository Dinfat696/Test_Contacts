package app.entity;


import jakarta.persistence.Entity;

@Entity
public class Email extends Contact{

    @Override
    public String getContact() {
        return ContactType.EMAIL.name();
    }
}
