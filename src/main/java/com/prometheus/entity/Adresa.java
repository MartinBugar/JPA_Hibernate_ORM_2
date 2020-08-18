package com.prometheus.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Adresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    private String ulica;
    private String mesto;
    private String psc;

    @OneToOne
    private Osoba osoba;

    public Adresa (){}

    public Long getId() {
        return id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresa adresa = (Adresa) o;
        return Objects.equals(id, adresa.id) &&
                Objects.equals(ulica, adresa.ulica) &&
                Objects.equals(mesto, adresa.mesto) &&
                Objects.equals(psc, adresa.psc) &&
                Objects.equals(osoba, adresa.osoba);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ulica, mesto, psc, osoba);
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "id='" + id + '\'' +
                ", ulica='" + ulica + '\'' +
                ", mesto='" + mesto + '\'' +
                ", psc='" + psc + '\'' +
                ", osoba=" + osoba +
                '}';
    }
}

//    CREATE TABLE Adresa (
//        ID int(19) NOT NULL AUTO_INCREMENT,
//    ULICA varchar(100) DEFAULT NULL,
//    MESTO varchar(100) DEFAULT NULL,
//    PSC varchar(100) DEFAULT NULL,
//    OSOBA_ID int(19) DEFAULT NULL,
//            PRIMARY KEY (ID)
//            );
//
//            ALTER TABLE Adresa ADD CONSTRAINT fk_adresa_osoba_id FOREIGN KEY (OSOBA_ID) REFERENCES osoba(ID);
