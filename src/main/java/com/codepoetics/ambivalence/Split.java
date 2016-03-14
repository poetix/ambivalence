package com.codepoetics.ambivalence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public final class Split<L, R> {

    Split() {
    }

    private final List<L> lefts = new ArrayList<>();
    private final List<R> rights = new ArrayList<>();

    public void accept(Either<L, R> value) {
        value.forEither(
                lefts::add,
                rights::add
        );
    }

    public <A, L2> CollectedSplit<L2, R> collectLefts(Collector<? super L, A, ? extends L2> collector) {
        return new CollectedSplit<>(lefts.stream().collect(collector), rights);
    }

    public Split<L, R> combine(Split<L, R> other) {
        lefts.addAll(other.lefts);
        rights.addAll(other.rights);
        return this;
    }

    public List<L> getLefts() {
        return lefts;
    }

    public List<R> getRights() {
        return rights;
    }
}
