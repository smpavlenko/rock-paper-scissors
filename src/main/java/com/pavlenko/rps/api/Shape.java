package com.pavlenko.rps.api;

/**
 * The Shape class which represents one of the three particular shapes: Rock,
 * Paper or Scissors.
 * 
 * @author Sergii Pavlenko
 * @since Dec 13, 2015
 */
public enum Shape {
    ROCK("paper"), PAPER("scissors"), SCISSORS("rock");

    private String beatenBy;

    private Shape(String beatenBy) {
        this.beatenBy = beatenBy;
    }

    /**
     * Checks if current shape can be beaten by target shape.
     * 
     * @param shape
     *            target shape
     * @return {@code true} if current shape can be beaten by argument shape,
     *         {@code false} - otherwise
     */
    public boolean isBeatenBy(Shape shape) {
        return shape.name().equalsIgnoreCase(beatenBy);
    }
}
