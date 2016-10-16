package com.pavlenko.rps.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

/**
 * Tests for {@link RockPlayer}.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class RockPlayerTest {

    private Player rockPlayer;

    @Before
    public void setUp() {
        rockPlayer = new RockPlayer();
    }

    @Test
    public void testMakeShape() throws Exception {
        assertEquals(Shape.ROCK, rockPlayer.makeShape());
    }
}
