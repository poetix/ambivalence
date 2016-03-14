package com.codepoetics.ambivalence;

import java.util.function.Function;

final class Left<L, R> extends Base<L, R> {
    private final L left;

    Left(L left) {
        this.left = left;
    }

    @Override
    public <O> O join(Function<? super L, ? extends O> lf, Function<? super R, ? extends O> rf) {
        return lf.apply(left);
    }
}
