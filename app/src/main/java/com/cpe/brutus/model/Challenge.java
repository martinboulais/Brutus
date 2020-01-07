package com.cpe.brutus.model;

import javax.xml.datatype.Duration;

/**
 * This class represents a challenge : its duration, its difficulty etc
 */
public class Challenge {

    /**
     * The duration of the challenge
     */
    private Duration duration;

    /**
     * The distance that should be run for the challenge
     */
    private int distance;

    /**
     * The difficulty of the challenge (defines the experience earned!)
     */
    private Difficulty difficulty;

    /**
     * The type of the effort, like sprint, long run...
     */
    private EffortType effortType;

    /**
     * Constructor
     *
     * @param duration the duration of the challenge
     * @param distance the distance of the challenge
     * @param difficulty the difficulty of the challenge
     * @param effortType the type of the effort
     */
    public Challenge(Duration duration, int distance, Difficulty difficulty, EffortType effortType) {
        this.duration = duration;
        this.distance = distance;
        this.difficulty = difficulty;
        this.effortType = effortType;
    }

// Getters and Setters

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public EffortType getEffortType() {
        return effortType;
    }

    public void setEffortType(EffortType effortType) {
        this.effortType = effortType;
    }
}
