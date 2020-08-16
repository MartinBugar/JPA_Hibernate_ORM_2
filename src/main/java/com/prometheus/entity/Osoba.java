package com.prometheus.entity;

import com.prometheus.converters.PohlavieConverter;
import com.prometheus.enums.Pohlavie;

import javax.persistence.*;

@Entity
public class Osoba extends Obcan{ // osoba dedi vsetko z obcana - vsetko co je v obcanovi je sucastou triedy osoba

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PohlavieConverter.class) //anotaciou sme povedali ze pohlavie budeme konvertovat pomocou PohlavieConverter classy
    private Pohlavie pohlavie;

    @Embedded
    private Meno meno;

    public Meno getMeno() {
        return meno;
    }

    public void setMeno(Meno meno) {
        this.meno = meno;
    }

    public Osoba(){}

    public Osoba(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pohlavie getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", pohlavie=" + pohlavie +
                ", meno=" + meno +
                '}' + super.toString();
    }
}

//CREATE TABLE Osoba(
//  ID int(19) NOT NULL AUTO_INCREMENT,
//  POHLAVIE varchar(1) DEFAULT NULL,
//  PRIMARY KEY (ID)
//);