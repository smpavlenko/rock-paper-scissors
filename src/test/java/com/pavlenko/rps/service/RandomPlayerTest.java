package com.pavlenko.rps.service;

import static com.pavlenko.rps.api.Shape.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

/**
 * Tests for {@link RandomPlayer}.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class RandomPlayerTest {

    private static final int ITERATIONS_COUNT = 100;
    private Player randomPlayer;

    @Before
    public void setUp() {
        randomPlayer = new RandomPlayer();
    }

    @Test
    public void testMakeShape() throws Exception {
        int paperCount = 0;
        int scissorsCount = 0;
        int rockCount = 0;

        for (int i = 0; i < ITERATIONS_COUNT; i++) {
            Shape shape = randomPlayer.makeShape();
            if (shape == PAPER) {
                paperCount++;
            }
            if (shape == SCISSORS) {
                scissorsCount++;
            }
            if (shape == ROCK) {
                rockCount++;
            }
        }

        assertTrue(paperCount > 0);
        assertTrue(scissorsCount > 0);
        assertTrue(rockCount > 0);

        assertEquals(ITERATIONS_COUNT, paperCount + scissorsCount + rockCount);
    }

}
