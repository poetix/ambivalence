package com.codepoetics.ambivalence;

import java.util.Optional;
import java.util.function.Function;

public interface RightProjection<L, R> extends Either<L, R>, Projection<R> {

    static <L, R> RightProjection<L, R> of(Either<L, R> either) {
        return new ConcreteRightProjection<>(either);
    }

    default <R2> RightProjection<L, R2> map(Function<? super R, ? extends R2> f) {
        return join(
                Either::<L, R2>ofLeft,
                f.andThen(Either::<L, R2>ofRight)).right();
    }

    default <R2> RightProjection<L, R2> flatMap(Function<? super R, ? extends Either<L, R2>> ff) {
        return join(Either::<L, R2>ofLeft, ff).right();
    }

    default Optional<R> toOptional() {
        return join(Functions.<L, R>constantEmpty(), Optional::<R>of);
    }
}
