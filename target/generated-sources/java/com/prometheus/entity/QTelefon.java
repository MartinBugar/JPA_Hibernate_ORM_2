package com.prometheus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTelefon is a Querydsl query type for Telefon
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTelefon extends EntityPathBase<Telefon> {

    private static final long serialVersionUID = -1499617017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTelefon telefon = new QTelefon("telefon");

    public final StringPath cislo = createString("cislo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOsoba osoba;

    public QTelefon(String variable) {
        this(Telefon.class, forVariable(variable), INITS);
    }

    public QTelefon(Path<? extends Telefon> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTelefon(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTelefon(PathMetadata metadata, PathInits inits) {
        this(Telefon.class, metadata, inits);
    }

    public QTelefon(Class<? extends Telefon> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.osoba = inits.isInitialized("osoba") ? new QOsoba(forProperty("osoba"), inits.get("osoba")) : null;
    }

}

