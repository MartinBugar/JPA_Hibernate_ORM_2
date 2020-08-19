package com.prometheus.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "skupina")
public class SkupinaKontaktov {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazov")
    private String nazovSkupiny;

    @ManyToMany //   jednosmerna, na strane osoby nembudeme mat zaznam o skupine//skupina je one//osoby su many
    @JoinTable(
            joinColumns = @JoinColumn(name = "skupina_id",
                    foreignKey = @ForeignKey(name = "fk_skupina_id")),
            inverseJoinColumns = @JoinColumn(name = "osoba_id",
                    foreignKey = @ForeignKey(name = "fk_2_osoba_id")))
    private List<Osoba> osobyVSkupine = new ArrayList<>();

    public SkupinaKontaktov(){}

    public String getNazovSkupiny() {
        return nazovSkupiny;
    }

    public void setNazovSkupiny(String nazovSkupiny) {
        this.nazovSkupiny = nazovSkupiny;
    }

    public List<Osoba> getOsobyVSkupine() {
        return osobyVSkupine;
    }

    public void setOsobyVSkupine(List<Osoba> osobyVSkupine) {
        this.osobyVSkupine = osobyVSkupine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkupinaKontaktov that = (SkupinaKontaktov) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nazovSkupiny, that.nazovSkupiny) &&
                Objects.equals(osobyVSkupine, that.osobyVSkupine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazovSkupiny, osobyVSkupine);
    }

    @Override
    public String toString() {
        return "SkupinaKontaktov{" +
                "id=" + id +
                ", nazovSkupiny='" + nazovSkupiny + '\'' +
                ", osobyVSkupine=" + osobyVSkupine +
                '}';
    }
}

//CREATE TABLE Skupina(
//    ID int(19) NOT NULL AUTO_INCREMENT,
//    NAZOV varchar(100)DEFAULT NULL,
//    PRIMARY KEY (ID)
//        );

// SPOJOVACIA TABULKA
//CREATE TABLE skupina_osoba (
//        skupina_id int(19) NOT NULL,
//    osoba_id int(19) NOT NULL,
//            PRIMARY KEY (skupina_id, osoba_id)
//);


// foreign key

//ALTER TABLE skupina_osoba ADD CONSTRAINT fk_skupina_id FOREIGN KEY (skupina_id) REFERENCES skupina(ID);
//ALTER TABLE skupina_osoba ADD CONSTRAINT fk_2_osoba_id FOREIGN KEY (osoba_id) REFERENCES OSOBA(ID);