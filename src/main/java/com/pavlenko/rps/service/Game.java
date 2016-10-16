package com.pavlenko.rps.service;

import java.util.HashMap;
import java.util.Map;

import com.pavlenko.rps.api.GameResult;
import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

/**
 * The Game class.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class Game {

    /**
     * Plays the particular count of game iterations between two players.
     * 
     * @param iterations
     *            count of iterations in the Game
     * @param firstPlayer
     *            first {@link Player} object
     * @param secondPlayer
     *            second {@link Player} object
     * @return {@link GameResult} object with information of the Game
     * @throws IllegalArgumentException
     *             if iterations count less than 1 or at least one of the player
     *             is {@code null}
     */
    public GameResult playGame(int iterations, Player firstPlayer, Player secondPlayer) {
        if (iterations <= 0) {
            throw new IllegalArgumentException("Number of iterations must be more than zero");
        }
        if (firstPlayer == null || secondPlayer == null) {
            throw new IllegalArgumentException(
                    String.format("One or both players are null: %s, %s", firstPlayer, secondPlayer));
        }

        int draws = 0;
        int firstPlayerWins = 0;
        int secondPlayerWins = 0;

        for (int i = 0; i < iterations; i++) {
            Shape firstShape = firstPlayer.makeShape();
            Shape secondShape = secondPlayer.makeShape();

            if (firstShape == secondShape) {
                draws++;
            } else if (firstShape.isBeatenBy(secondShape)) {
                secondPlayerWins++;
            } else {
                firstPlayerWins++;
            }
        }

        Map<Player, Integer> resultMap = new HashMap<Player, Integer>();
        resultMap.put(firstPlayer, firstPlayerWins);
        resultMap.put(secondPlayer, secondPlayerWins);

        GameResult result = new GameResult();
        result.setGamesCount(iterations);
        result.setDrawsCount(draws);
        result.setResultMap(resultMap);

        return result;
    }

}
