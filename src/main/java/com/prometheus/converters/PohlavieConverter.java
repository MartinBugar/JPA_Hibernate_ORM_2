package com.prometheus.converters;

import com.prometheus.enums.Pohlavie;

import javax.persistence.AttributeConverter;

public class PohlavieConverter implements AttributeConverter <Pohlavie, Character> {


    @Override
    public Character convertToDatabaseColumn(Pohlavie pohlavie) { // parameter v zatvorke sa konvertuje na atrubut do databazy, takze chceme z pohlavia vratit kod
        if (pohlavie == null){
            return null;
        }
        return pohlavie.getKod();
    }

    @Override
    public Pohlavie convertToEntityAttribute(Character character) { // z pametrea v zatvorke chceme spravit atribut Enum
        if (character == null) {
            return null;
        }
        return Pohlavie.getEnumFromKod(character);
    }
}
