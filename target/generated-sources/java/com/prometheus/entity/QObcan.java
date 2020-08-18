package com.prometheus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QObcan is a Querydsl query type for Obcan
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QObcan extends EntityPathBase<Obcan> {

    private static final long serialVersionUID = 1137856585L;

    public static final QObcan obcan = new QObcan("obcan");

    public final StringPath cisloOp = createString("cisloOp");

    public QObcan(String variable) {
        super(Obcan.class, forVariable(variable));
    }

    public QObcan(Path<? extends Obcan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObcan(PathMetadata metadata) {
        super(Obcan.class, metadata);
    }

}

