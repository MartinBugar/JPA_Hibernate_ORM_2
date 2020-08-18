package com.prometheus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdresa is a Querydsl query type for Adresa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdresa extends EntityPathBase<Adresa> {

    private static final long serialVersionUID = 515305656L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdresa adresa = new QAdresa("adresa");

    public final StringPath id = createString("id");

    public final StringPath mesto = createString("mesto");

    public final QOsoba osoba;

    public final StringPath psc = createString("psc");

    public final StringPath ulica = createString("ulica");

    public QAdresa(String variable) {
        this(Adresa.class, forVariable(variable), INITS);
    }

    public QAdresa(Path<? extends Adresa> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdresa(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdresa(PathMetadata metadata, PathInits inits) {
        this(Adresa.class, metadata, inits);
    }

    public QAdresa(Class<? extends Adresa> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.osoba = inits.isInitialized("osoba") ? new QOsoba(forProperty("osoba"), inits.get("osoba")) : null;
    }

}

