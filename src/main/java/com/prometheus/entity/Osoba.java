package com.prometheus.entity;

import com.prometheus.converters.PohlavieConverter;
import com.prometheus.enums.Pohlavie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//parent trieda
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

    // ak je na jednej strane ManyToOne  a na druhej stranke OneToMany tak je to obojsmerne
    //kazda obojsmerna asociacia musi mat nejakeho vlastnika, vlastnik je vzdy child strana
    //parentova strana je referencovana
    @OneToMany(mappedBy = "osoba",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Telefon> telefons = new HashSet<>(); //OneToMany - jedna osoba k viac telefonom

    @ManyToMany(mappedBy = "osobyVSkupine", fetch = FetchType.LAZY)
    private Set<SkupinaKontaktov> skupinyOsoby = new HashSet<>();

    public Osoba(){}

    @OneToOne(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Adresa adresa;

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", pohlavie=" + pohlavie +
                ", meno=" + meno +
                ", telefons=" + telefons +
                ", skupinyOsoby=" + skupinyOsoby +
                ", adresa=" + adresa +
                '}';
    }

    public Set<Telefon> getTelefons() {
        return telefons;
    }

    public void setTelefons(Set<Telefon> telefons) {
        this.telefons = telefons;
    }

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

//CREATE TABLE Osoba(
//  ID int(19) NOT NULL AUTO_INCREMENT,
//  POHLAVIE varchar(1) DEFAULT NULL,
//  PRIMARY KEY (ID)
//);

//pripojenie na telefon
//        select *
//        from osoba
//        LEFT JOIN telefon on osoba.id = telefon.OSOBA_ID;