package com.codepoetics.ambivalence;

import java.util.stream.Collector;

public final class Eithers {

    private Eithers() {
    }

    public static <T, E> Collector<Either<T, E>, Split<T, E>, Split<T, E>> split() {
        return Collector.of(
                Split::new,
                Split::accept,
                Split::combine
        );
    }

    public static <T, A, R, E> Collector<Either<T, E>, Split<T, E>, CollectedSplit<R, E>> splitAndCollectLeft(Collector<? super T, A, ? extends R> leftCollector) {
        return Collector.of(
                Split::new,
                Split::accept,
                Split::combine,
                split -> split.collectLefts(leftCollector)
        );
    }

}
