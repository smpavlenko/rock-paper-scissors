package com.pavlenko.rps.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.pavlenko.rps.api.GameResult;
import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

public class ParallelGame {

    public GameResult playGame(int iterations, final Player firstPlayer, final Player secondPlayer) {
        if (iterations <= 0) {
            throw new IllegalArgumentException("Number of iterations must be more than zero");
        }
        if (firstPlayer == null || secondPlayer == null) {
            throw new IllegalArgumentException(
                    String.format("One or both players are null: %s, %s", firstPlayer, secondPlayer));
        }

        final AtomicInteger draws = new AtomicInteger();
        final AtomicInteger firstPlayerWins = new AtomicInteger();
        final AtomicInteger secondPlayerWins = new AtomicInteger();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < iterations; i++) {

            executor.submit(new Runnable() {

                @Override
                public void run() {
                    Shape firstShape = firstPlayer.makeShape();
                    Shape secondShape = secondPlayer.makeShape();

                    if (firstShape == secondShape) {
                        draws.incrementAndGet();
                    } else if (firstShape.isBeatenBy(secondShape)) {
                        secondPlayerWins.incrementAndGet();
                    } else {
                        firstPlayerWins.incrementAndGet();
                    }
                }

            });

        }

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

        Map<Player, Integer> resultMap = new HashMap<Player, Integer>();
        resultMap.put(firstPlayer, firstPlayerWins.get());
        resultMap.put(secondPlayer, secondPlayerWins.get());

        GameResult result = new GameResult();
        result.setGamesCount(iterations);
        result.setDrawsCount(draws.get());
        result.setResultMap(resultMap);

        return result;
    }
}
