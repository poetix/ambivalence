package com.codepoetics.ambivalence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;

public final class Split<L, R> implements Consumer<Either<? extends L, ? extends R>> {

    Split() {
    }

    private final List<L> lefts = new ArrayList<>();
    private final List<R> rights = new ArrayList<>();

    @Override
    public void accept(Either<? extends L, ? extends R> value) {
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
