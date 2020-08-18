package com.prometheus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOsoba is a Querydsl query type for Osoba
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOsoba extends EntityPathBase<Osoba> {

    private static final long serialVersionUID = 1138374582L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOsoba osoba = new QOsoba("osoba");

    public final QObcan _super = new QObcan(this);

    public final QAdresa adresa;

    //inherited
    public final StringPath cisloOp = _super.cisloOp;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMeno meno;

    public final EnumPath<com.prometheus.enums.Pohlavie> pohlavie = createEnum("pohlavie", com.prometheus.enums.Pohlavie.class);

    public final SetPath<SkupinaKontaktov, QSkupinaKontaktov> skupinyOsoby = this.<SkupinaKontaktov, QSkupinaKontaktov>createSet("skupinyOsoby", SkupinaKontaktov.class, QSkupinaKontaktov.class, PathInits.DIRECT2);

    public final SetPath<Telefon, QTelefon> telefons = this.<Telefon, QTelefon>createSet("telefons", Telefon.class, QTelefon.class, PathInits.DIRECT2);

    public QOsoba(String variable) {
        this(Osoba.class, forVariable(variable), INITS);
    }

    public QOsoba(Path<? extends Osoba> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOsoba(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOsoba(PathMetadata metadata, PathInits inits) {
        this(Osoba.class, metadata, inits);
    }

    public QOsoba(Class<? extends Osoba> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adresa = inits.isInitialized("adresa") ? new QAdresa(forProperty("adresa"), inits.get("adresa")) : null;
        this.meno = inits.isInitialized("meno") ? new QMeno(forProperty("meno")) : null;
    }

}

