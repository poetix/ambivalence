package com.codepoetics.ambivalence;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

@FunctionalInterface
public interface Projection<T> {
    Optional<T> toOptional();
    default Stream<T> stream() {
        return toOptional().map(Stream::of).orElseGet(Stream::empty);
    }
    default void ifPresent(Consumer<? super T> consumer) {
        toOptional().ifPresent(consumer);
    }
    default T orElse(T other) {
        return toOptional().orElse(other);
    }
    default T orElseGet(Supplier<? extends T> otherSupplier) {
        return toOptional().orElseGet(otherSupplier);
    }
    default <E extends Throwable> T orElseThrow(Supplier<E> exceptionSupplier) throws E {
        return toOptional().orElseThrow(exceptionSupplier);
    }
}
