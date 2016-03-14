package com.codepoetics.ambivalence;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.codepoetics.ambivalence.Consumers.toVoidFunction;
import static com.codepoetics.ambivalence.Functions.constant;

@FunctionalInterface
public interface Either<L, R> {

    static <L, R> Either<L, R> ofLeft(L left) {
        return new Left<>(left);
    }

    static <L, R> Either<L, R> ofRight(R right) {
        return new Right<>(right);
    }

    <O> O join(Function<? super L, ? extends O> left, Function<? super R, ? extends O> right);

    default boolean isLeft() {
        return join(constant(true), constant(false));
    }

    default boolean isRight() {
        return join(constant(false), constant(true));
    }

    default void forEither(Consumer<? super L> left, Consumer<? super R> right) {
        join(toVoidFunction(left), toVoidFunction(right));
    }

    default <L2, R2> Either<L2, R2> map(Function<? super L, ? extends L2> left, Function<? super R, ? extends R2> right) {
        return join(left.andThen(Either::<L2, R2>ofLeft), right.andThen(Either::<L2, R2>ofRight));
    }

    default LeftProjection<L, R> left() { return LeftProjection.of(this); }
    default RightProjection<L, R> right() { return RightProjection.of(this); }

}
