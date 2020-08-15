package com.prometheus.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Message")
public class Message {

//MAPOVANIE NIE JE CASE SENSITIVE, ignorujeme velke a male pismena

//SPOSOBY GENEROVANIE STRATEGIE ID
    // ked je strategy auto tak to robi hibernate, to sa odporuca nepouzivat
    // ked je identity tak inkrementovanie je ponechane databaze, ale musi byt v databze auto inkrement
    // ked je sequence tak databaza vybera so svojich prednastavenych sekvenci
    // priklad na sekvenciu
    /*
            @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "daco_SEQ")
            @SequenceGenerator(name = "daco_SEQ", sequenceName = "daco_SEQ", allocationSize = 1)
            private Long id;
    */
    // ked je strategy table tak je to podobne ako sekvencia - nepouzivat
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MESSAGE") // ak je nazov stplca totozny s premennou, tak to netreba davat to column, najde si to same
    private String message;

    @Column(name = "CREATE_DATE")
    private Date CREATE_DATE;


    public Message (){}

    public Message(String message) {
        this.message = message;
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(id, message1.id) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
