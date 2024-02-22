package app.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Client.class)
public class Client_ {
    public static volatile SingularAttribute<Client, Long> clientId;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile ListAttribute<Client, Contact> telephones;
    public static volatile ListAttribute<Client, Contact> emails;
}


