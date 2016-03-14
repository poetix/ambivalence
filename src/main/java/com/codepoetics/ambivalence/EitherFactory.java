package com.codepoetics.ambivalence;

public final class EitherFactory<L, R> {

    public static <L, R> EitherFactory<L, R> forTypes(Class<? extends L> leftType, Class<? extends R> rightType) {
        return new EitherFactory<>();
    }

    public Either<L, R> makeLeft(L left) {
        return Either.ofLeft(left);
    }

    public Either<L, R> makeRight(R right) {
        return Either.ofRight(right);
    }
}
