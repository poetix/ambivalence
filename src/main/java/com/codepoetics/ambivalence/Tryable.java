package com.codepoetics.ambivalence;

import java.util.function.Function;

public interface Tryable<I, O, E extends Exception> extends Function<I, Either<O, E>> {

    static <I, O, E extends Exception> Function<I, Either<O, E>> of(Tryable<I, O, E> tryable) {
        return tryable;
    }

    @SuppressWarnings("unsafe")
    @Override
    default Either<O, E> apply(I input) {
        try {
            return Either.ofLeft(applyThrowing(input));
        } catch (Exception e) {
            return Either.ofRight((E) e);
        }
    }

    O applyThrowing(I input) throws E;
}
