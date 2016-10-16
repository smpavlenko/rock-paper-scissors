package com.pavlenko.rps.api;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link GameResult}.
 *
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class GameResultTest {

    private GameResult gameResult;
    private Player player;
    private Player unknownPlayer;

    @Before
    public void setUp() {
        player = () -> Shape.PAPER;
        unknownPlayer = () -> Shape.SCISSORS;

        Map<Player, Integer> resultMap = new HashMap<>();
        resultMap.put(player, 1);

        gameResult = new GameResult();
        gameResult.setResultMap(resultMap);
        gameResult.setDrawsCount(0);
        gameResult.setGamesCount(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWinsCountNullArgument() throws Exception {
        gameResult.getWinsCount(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWinsCountUnknownPlayer() throws Exception {
        gameResult.getWinsCount(unknownPlayer);
    }

    @Test
    public void testGetWinsCountDefinedPlayer() throws Exception {
        assertEquals(1, gameResult.getWinsCount(player));
    }
}
