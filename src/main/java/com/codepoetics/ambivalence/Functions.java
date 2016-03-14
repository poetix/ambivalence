package com.codepoetics.ambivalence;

import java.util.Optional;
import java.util.function.Function;

final class Functions {

    private Functions() {
    }

    static <I, O> Function<I, O> constant(O constant) {
        return i -> constant;
    }

    static <I, O> Function<I, Optional<O>> constantEmpty() {
        return constant(Optional.empty());
    }
}
