package com.prometheus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSkupinaKontaktov is a Querydsl query type for SkupinaKontaktov
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSkupinaKontaktov extends EntityPathBase<SkupinaKontaktov> {

    private static final long serialVersionUID = 692056146L;

    public static final QSkupinaKontaktov skupinaKontaktov = new QSkupinaKontaktov("skupinaKontaktov");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nazovSkupiny = createString("nazovSkupiny");

    public final ListPath<Osoba, QOsoba> osobyVSkupine = this.<Osoba, QOsoba>createList("osobyVSkupine", Osoba.class, QOsoba.class, PathInits.DIRECT2);

    public QSkupinaKontaktov(String variable) {
        super(SkupinaKontaktov.class, forVariable(variable));
    }

    public QSkupinaKontaktov(Path<? extends SkupinaKontaktov> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSkupinaKontaktov(PathMetadata metadata) {
        super(SkupinaKontaktov.class, metadata);
    }

}

