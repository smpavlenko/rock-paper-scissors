package com.pavlenko.rps.service;

import com.pavlenko.rps.api.Player;
import com.pavlenko.rps.api.Shape;

/**
 * Represents the {@link Player} which always forms {@code Rock} {@link Shape}
 * during the {@link Game}.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public class RockPlayer implements Player {

    @Override
    public Shape makeShape() {
        return Shape.ROCK;
    }

    @Override
    public String toString() {
        return "RockPlayer";
    }

}
