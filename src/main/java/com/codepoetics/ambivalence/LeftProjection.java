package com.codepoetics.ambivalence;

import java.util.Optional;
import java.util.function.Function;

public interface LeftProjection<L, R> extends Either<L, R>, Projection<L> {

    static <L, R> LeftProjection<L, R> of(Either<L, R> either) {
        return new ConcreteLeftProjection<>(either);
    }

    default <L2> LeftProjection<L2, R> map(Function<? super L, ? extends L2> f) {
        return join(
                f.andThen(Either::<L2, R>ofLeft),
                Either::<L2, R>ofRight).left();
    }

    default <L2> LeftProjection<L2, R> flatMap(Function<? super L, ? extends Either<L2, R>> ff) {
        return join(ff, Either::<L2, R>ofRight).left();
    }

    default Optional<L> toOptional() {
        return join(Optional::<L>of, Functions.<R, L>constantEmpty());
    }
}
