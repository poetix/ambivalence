package com.codepoetics.ambivalence;

import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TryableTest {

    @Test
    public void successIsLeft() {
        assertTrue(Tryable.of(i -> i).apply(3).isLeft());
        assertEquals(Optional.of(6), Tryable.of((Integer i) -> i * 2).apply(3).left().toOptional());
    }

    @Test
    public void failureIsRight() {
        IOException exception = new IOException();
        assertTrue(Tryable.of(i -> { throw exception; }).apply(3).isRight());
        assertEquals(Optional.of(exception), Tryable.of(i -> { throw exception; }).apply(3).right().toOptional());
    }

}
