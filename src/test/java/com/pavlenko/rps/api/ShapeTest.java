package com.pavlenko.rps.api;

import static com.pavlenko.rps.api.Shape.PAPER;
import static com.pavlenko.rps.api.Shape.ROCK;
import static com.pavlenko.rps.api.Shape.SCISSORS;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for {@link Shape}.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class ShapeTest {

    @Test
    public void testPaperBeatenBy() throws Exception {
        assertTrue(PAPER.isBeatenBy(SCISSORS));
        assertFalse(PAPER.isBeatenBy(ROCK));
        assertFalse(PAPER.isBeatenBy(PAPER));
    }

    @Test
    public void testScissorsBeatenBy() throws Exception {
        assertTrue(SCISSORS.isBeatenBy(ROCK));
        assertFalse(SCISSORS.isBeatenBy(PAPER));
        assertFalse(SCISSORS.isBeatenBy(SCISSORS));
    }

    @Test
    public void testRockBeatenBy() throws Exception {
        assertTrue(ROCK.isBeatenBy(PAPER));
        assertFalse(ROCK.isBeatenBy(SCISSORS));
        assertFalse(ROCK.isBeatenBy(ROCK));
    }
}
