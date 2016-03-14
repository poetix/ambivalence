package com.codepoetics.ambivalence;

import java.util.function.Function;

abstract class BaseProjection<L, R> extends Base<L, R> {

    private final Either<L, R> either;

    BaseProjection(Either<L, R> either) {
        this.either = either;
    }

    @Override
    public <O> O join(Function<? super L, ? extends O> left, Function<? super R, ? extends O> right) {
        return either.join(left, right);
    }
}
