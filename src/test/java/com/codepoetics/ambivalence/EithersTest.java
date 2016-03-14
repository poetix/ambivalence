package com.codepoetics.ambivalence;

import org.junit.Test;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codepoetics.ambivalence.Eithers.splitAndCollectLeft;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class EithersTest {

    @Test
    public void splitLeftsFromRights() {
        EitherFactory<String, Integer> factory = new EitherFactory<>();

        final EitherSplit<String, Integer> result = Stream.of(
                factory.makeLeft("foo"),
                factory.makeRight(12),
                factory.makeRight(23),
                factory.makeLeft("bar")
        ).collect(Eithers.split());

        assertThat(result.getLefts(), contains("foo", "bar"));
        assertThat(result.getRights(), contains(12, 23));
    }

    @Test
    public void splitAndCollect() {
        EitherFactory<String, Integer> factory = new EitherFactory<>();

        final SplitResult<String, Integer> result = Stream.of(
                factory.makeLeft("foo"),
                factory.makeRight(12),
                factory.makeRight(23),
                factory.makeLeft("bar")
        ).collect(splitAndCollectLeft(Collectors.joining(",")));

        assertThat(result.getLeft(), equalTo("foo,bar"));
        assertThat(result.getRights(), contains(12, 23));
    }

    @Test
    public void splitAndCollectWithTryable() {
        SplitResult<String, IOException> result = Stream.of("a", "bee", "cee", "d")
                .map(Tryable.of(c -> {
                    if (c.length() ==1) {
                        return c;
                    } else {
                        throw new IOException("String too long");
                    }
                }))
                .collect(splitAndCollectLeft(Collectors.joining(",")));

        assertThat(result.getLeft(), equalTo("a,d"));
        assertThat(result.getRights(), hasSize(2));
    }
}
