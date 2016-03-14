package com.codepoetics.ambivalence;

import java.util.function.Function;

final class Right<L, R> extends Base<L, R> {
    private final R right;

    Right(R right) {
        this.right = right;
    }

    @Override
    public <O> O join(Function<? super L, ? extends O> lf, Function<? super R, ? extends O> rf) {
        return rf.apply(right);
    }
}
