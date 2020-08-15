package com.prometheus.entity;

import com.prometheus.converters.PohlavieConverter;
import com.prometheus.enums.Pohlavie;

import javax.persistence.*;

@Entity
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PohlavieConverter.class) //anotaciou sme povedali ze pohlavie budeme konvertovat pomocou PohlavieConverter classy
    private Pohlavie pohlavie;

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
}
