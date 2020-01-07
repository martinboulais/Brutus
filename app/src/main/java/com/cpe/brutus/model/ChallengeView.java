package com.cpe.brutus.model;

import javax.xml.datatype.Duration;

/**
 * This class represents a view of a challenge, it's a kind of "read only" representation of a
 * challenge
 */
public class ChallengeView {

    /**
     * The challenge this view wraps
     */
    private Challenge challenge;

    /**
     * Constructor
     *
     * @param duration the duration of the wrapped challenge
     * @param distance the distance of the wrapped challenge
     * @param difficulty the difficulty of the wrapped challenge
     * @param effortType the type of the effort of the wrapped challenge
     */
    public ChallengeView(
            Duration duration,
            int distance,
            Difficulty difficulty,
            EffortType effortType
    ) {

        this.challenge = new Challenge(duration, distance, difficulty, effortType);
    }

    /**
     * Constructor
     *
     * @param challenge the challenge we should wrap
     */
    public ChallengeView(Challenge challenge) {

        this.challenge = challenge;
    }

    /**
     * Return the experience gain of the challenge
     */
    public int getExperienceGain() {

        return this.challenge.getDifficulty().getExperienceGain();
    }

// Getters and Setters

    public Duration getDuration() {
        return challenge.getDuration();
    }

    public int getDistance() {
        return challenge.getDistance();
    }

    public Difficulty getDifficulty() {
        return challenge.getDifficulty();
    }

    public EffortType getEffortType() {
        return challenge.getEffortType();
    }
}
