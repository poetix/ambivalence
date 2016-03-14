package com.codepoetics.ambivalence;

import java.util.stream.Collector;

public final class Eithers {

    private Eithers() {
    }

    public static <T, E> Collector<Either<T, E>, EitherSplit<T, E>, EitherSplit<T, E>> split() {
        return Collector.of(
                EitherSplit::new,
                EitherSplit::accept,
                EitherSplit::combine
        );
    }

    public static <T, A, R, E> Collector<Either<T, E>, EitherSplit<T, E>, SplitResult<R, E>> splitAndCollectLeft(Collector<? super T, A, ? extends R> leftCollector) {
        return Collector.of(
                EitherSplit::new,
                EitherSplit::accept,
                EitherSplit::combine,
                split -> split.collectLefts(leftCollector)
        );
    }

}
