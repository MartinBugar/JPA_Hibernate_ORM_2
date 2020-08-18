package com.prometheus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMeno is a Querydsl query type for Meno
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMeno extends BeanPath<Meno> {

    private static final long serialVersionUID = 1560669357L;

    public static final QMeno meno = new QMeno("meno");

    public final StringPath priezvisko = createString("priezvisko");

    public final StringPath prveMeno = createString("prveMeno");

    public final StringPath stredneMeno = createString("stredneMeno");

    public final StringPath titulPred = createString("titulPred");

    public final StringPath titulZa = createString("titulZa");

    public QMeno(String variable) {
        super(Meno.class, forVariable(variable));
    }

    public QMeno(Path<? extends Meno> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMeno(PathMetadata metadata) {
        super(Meno.class, metadata);
    }

}

