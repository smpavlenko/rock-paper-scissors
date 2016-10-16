package com.pavlenko.rps.service;

import java.util.Random;

import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

/**
 * Represents the {@link Player} which always forms random {@link Shape} during
 * the {@link Game}.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class RandomPlayer implements Player {

    private static final Random RND = new Random();

    @Override
    public Shape makeShape() {
        return Shape.values()[RND.nextInt(Shape.values().length)];
    }

    @Override
    public String toString() {
        return "RandomPlayer";
    }

}
