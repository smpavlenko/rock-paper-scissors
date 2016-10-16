package com.pavlenko.rps.api;

import com.pavlenko.rps.service.Game;

/**
 * Player interface. A common interface for every player in Rock-Paper-Scissors
 * game.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public interface Player {

    /**
     * Forms and returns a {@link Shape} during the particular {@link Game}.
     * 
     * @return {@link Shape} object
     */
    Shape makeShape();
}
