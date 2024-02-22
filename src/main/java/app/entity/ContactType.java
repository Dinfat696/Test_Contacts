package app.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Optional;


public enum ContactType {
    TELEPHONE("telephone"),
    EMAIL("email");
    private final String value;

    ContactType(String value) {
        this.value = value;
    }
    public static Optional<ContactType> value(String value){
        return Arrays.stream(values())
                .filter(c->c.value.equalsIgnoreCase(value))
                .findFirst();
    }
}
