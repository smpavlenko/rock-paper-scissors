package com.pavlenko.rps.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pavlenko.rps.api.GameResult;
import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

/**
 * Tests for {@link Game}.
 *
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class GameTest {

    private static final int ITERATIONS_COUNT = 100;
    private Game game;
    private Player paperPlayer;
    private Player rockPlayer;
    private Player randomPlayer;

    @Before
    public void setUp() {
        game = new Game();
        rockPlayer = new RockPlayer();
        randomPlayer = new RandomPlayer();

        paperPlayer = () -> Shape.PAPER;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayGameWithZeroIterations() throws Exception {
        game.playGame(0, rockPlayer, randomPlayer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayGameWithNullFirstPlayer() throws Exception {
        game.playGame(ITERATIONS_COUNT, null, randomPlayer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayGameWithNullSecondPlayer() throws Exception {
        game.playGame(ITERATIONS_COUNT, rockPlayer, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayGamePlayerDidnotParticipate() throws Exception {
        GameResult result = game.playGame(1, rockPlayer, randomPlayer);
        result.getWinsCount(paperPlayer);
    }

    @Test
    public void testPlayGameWithOneIteration() throws Exception {
        GameResult result = game.playGame(1, rockPlayer, randomPlayer);

        assertNotNull(result);
        assertEquals(1, result.getGameCount());
        assertNotNull(result.getPlayers());
        assertEquals(2, result.getPlayers().size());
        assertTrue(result.getPlayers().contains(rockPlayer));
        assertTrue(result.getPlayers().contains(randomPlayer));
        assertTrue(result.getWinsCount(rockPlayer) == 1 || result.getWinsCount(randomPlayer) == 1
                || result.getDrawsCount() == 1);
    }

    @Test
    public void testPlayGameWithHundredIterations() throws Exception {
        GameResult result = game.playGame(ITERATIONS_COUNT, rockPlayer, randomPlayer);

        assertNotNull(result);
        assertEquals(ITERATIONS_COUNT, result.getGameCount());
        assertNotNull(result.getPlayers());
        assertEquals(2, result.getPlayers().size());
        assertTrue(result.getPlayers().contains(rockPlayer));
        assertTrue(result.getPlayers().contains(randomPlayer));
        assertEquals(ITERATIONS_COUNT,
                result.getWinsCount(rockPlayer) + result.getWinsCount(randomPlayer) + result.getDrawsCount());
    }

    @Test
    public void testPlayGameRockWithPaper() throws Exception {
        GameResult result = game.playGame(ITERATIONS_COUNT, rockPlayer, paperPlayer);

        assertNotNull(result);
        assertEquals(ITERATIONS_COUNT, result.getGameCount());
        assertNotNull(result.getPlayers());
        assertEquals(2, result.getPlayers().size());
        assertTrue(result.getPlayers().contains(rockPlayer));
        assertTrue(result.getPlayers().contains(paperPlayer));
        assertEquals(0, result.getWinsCount(rockPlayer));
        assertEquals(ITERATIONS_COUNT, result.getWinsCount(paperPlayer));
        assertEquals(0, result.getDrawsCount());
    }

    @Test
    public void testPlayGameWithAllDraws() throws Exception {
        GameResult result = game.playGame(ITERATIONS_COUNT, rockPlayer, rockPlayer);

        assertNotNull(result);
        assertEquals(ITERATIONS_COUNT, result.getGameCount());
        assertNotNull(result.getPlayers());
        assertEquals(1, result.getPlayers().size());
        assertTrue(result.getPlayers().contains(rockPlayer));
        assertEquals(0, result.getWinsCount(rockPlayer));
        assertEquals(ITERATIONS_COUNT, result.getDrawsCount());
    }
}
