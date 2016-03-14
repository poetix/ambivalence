package com.codepoetics.ambivalence;

final class ConcreteLeftProjection<L, R> extends BaseProjection<L, R> implements LeftProjection<L, R> {
    ConcreteLeftProjection(Either<L, R> either) {
        super(either);
    }
}
