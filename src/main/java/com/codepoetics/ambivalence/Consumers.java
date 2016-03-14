package com.codepoetics.ambivalence;

import java.util.function.Consumer;
import java.util.function.Function;

final class Consumers {

    private Consumers() {
    }

    static <I> Function<I, Void> toVoidFunction(Consumer<I> consumer) {
        return i -> {
            consumer.accept(i);
            return null;
        };
    }
}
