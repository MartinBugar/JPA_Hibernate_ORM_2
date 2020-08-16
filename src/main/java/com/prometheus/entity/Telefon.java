package com.prometheus.entity;

import javax.persistence.*;

@Entity
public class Telefon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String cislo;

    @ManyToOne//vela telefonov pre jednu osobu
    @JoinColumn(name = "osoba_id",foreignKey = @ForeignKey(name = "fk_telefon_osoba_id"))
    private Osoba osoba;


    //kazda entita musi mat prazdny konstruktor
    public Telefon(){}

    public Long getId() {
        return id;
    }

    public String getCislo() {
        return cislo;
    }

    public void setCislo(String cislo) {
        this.cislo = cislo;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "id=" + id +
                ", cislo='" + cislo + '\'' +
                ", osoba=" + osoba +
                '}';
    }
}

//      CREATE TABLE Telefon(
//          ID int(19) NOT NULL AUTO_INCREMENT,
//          CISLO nvarchar(100) DEFAULT NULL,
//          OSOBA_ID int(19) DEFAULT NULL,
//          primary key (ID)
//      );

// ALTER table TELEFON ADD CONSTRAINT fk_telefon_osoba_id FOREIGN KEY (osoba_id) REFERENCES OSOBA(ID);
