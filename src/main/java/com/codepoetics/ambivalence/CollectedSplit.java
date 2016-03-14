package com.codepoetics.ambivalence;

import java.util.List;

public final class CollectedSplit<L, R> {
    private final L left;
    private final List<R> rights;

    CollectedSplit(L left, List<R> rights) {
        this.left = left;
        this.rights = rights;
    }

    public L getLeft() {
        return left;
    }

    public List<R> getRights() {
        return rights;
    }
}
