package com.pavlenko.rps.api;

import java.util.Map;
import java.util.Set;
import com.pavlenko.rps.service.Game;

/**
 * Represents a result of particular {@link Game}. Contains count of game
 * iterations, draw counts and count of winnings of every {@link Player}.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class GameResult {

    private int gamesCount;
    private int drawsCount;
    private Map<Player, Integer> resultMap;

    public void setResultMap(Map<Player, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

    public int getGameCount() {
        return gamesCount;
    }

    public Set<Player> getPlayers() {
        return resultMap.keySet();
    }

    public void setDrawsCount(int drawsCount) {
        this.drawsCount = drawsCount;
    }

    public int getDrawsCount() {
        return drawsCount;
    }

    /**
     * Checks the count of winnings of the particular {@link Player}.
     * 
     * @param player
     *            target {@link Player}
     * @return the count of winnings of the {@link Player}
     * @throws IllegalArgumentException
     *             if target {@link Player} didn't participate in the
     *             {@link Game}
     */
    public int getWinsCount(Player player) {
        if (!resultMap.containsKey(player)) {
            throw new IllegalArgumentException(String.format("Player %s didn't participate in the game", player));
        }

        return resultMap.get(player);
    }
}
