package com.codepoetics.ambivalence;

import static com.codepoetics.ambivalence.Functions.constant;

abstract class Base<L, R> implements Either<L, R> {
    @Override
    public boolean equals(Object o) {
        return o == this
                || ((o instanceof Either)
                && ((Either<?, ?>) o).join(
                otherL -> join(l -> otherL.equals(l), constant(false)),
                otherR -> join(constant(false), r -> otherR.equals(r))));
    }

    @Override
    public int hashCode() {
        return join(Object::hashCode, r -> -r.hashCode());
    }

    @Override
    public String toString() {
        return join(
                l -> String.format("left(%s)", l),
                r -> String.format("right(%s)", r));
    }
}
