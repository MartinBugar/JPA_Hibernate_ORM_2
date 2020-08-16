package com.prometheus.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //nieje povazovana za entitu, ale ju mapujeme a rodicovska trieda je entita
public class Obcan {

    @Column(name = "cislo_op")
    private String cisloOp;

    public String getCisloOp() {
        return cisloOp;
    }

    public void setCisloOp(String cisloOp) {
        this.cisloOp = cisloOp;
    }
}

// ALTER TABLE Osoba ADD COLUMN cislo_op nvarchar(100)
