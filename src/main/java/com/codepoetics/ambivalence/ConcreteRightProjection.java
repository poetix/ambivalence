package com.codepoetics.ambivalence;

final class ConcreteRightProjection<L, R> extends BaseProjection<L, R> implements RightProjection<L, R> {
    ConcreteRightProjection(Either<L, R> either) {
        super(either);
    }
}
