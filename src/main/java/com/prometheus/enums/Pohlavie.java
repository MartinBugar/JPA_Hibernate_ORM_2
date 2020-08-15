package com.prometheus.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Pohlavie {
    MUZ('M'),
    ZENA('Z');

    private char kod;

    Pohlavie (char kod){
        this.kod = kod;
    }

    public static Pohlavie getEnumFromKod(Character kod) {
        if (kod.equals('M') || kod.equals('m')){
            return MUZ;
        }
        else if (kod.equals('Z') || kod.equals('z')) {
            return ZENA;
        }

        else throw new UnsupportedOperationException("NIC SU NENI");
    }

    public char getKod() {
        return kod;
    }

    public void setKod(char kod) {
        this.kod = kod;
    }
//    @Enumerated(EnumType.ORDINAL) // v databaze musi byt v type ktory reprezentuje cele cisla, MUZ - 0, ZENa - 1 , NIC - null
//    @Enumerated(EnumType.STRING)  // // v databaze musi byt v type ktory reprezentuje retazec

    // je mozne spravit si vlastnu strategiu ukladanie enumov do databazy - treba nato ale ich konvertovat- atributeConverter
}


