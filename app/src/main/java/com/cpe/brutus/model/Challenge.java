package com.cpe.brutus.model;

import java.io.Serializable;

/**
 * This class represents a challenge : its mDuration, its mDifficulty etc
 */
public class Challenge implements Serializable {

    /**
     * The mDuration of the challenge
     */
    private SecondsDuration mDuration;

    /**
     * The mDistance that should be run for the challenge
     */
    private int mDistance;

    /**
     * The mDifficulty of the challenge (defines the experience earned!)
     */
    private Difficulty mDifficulty;

    /**
     * The type of the effort, like sprint, long run...
     */
    private EffortType mEffortType;

    /**
     * Constructor
     *
     * @param duration the mDuration of the challenge
     * @param distance the mDistance of the challenge
     * @param difficulty the mDifficulty of the challenge
     * @param effortType the type of the effort
     */
    public Challenge(SecondsDuration duration, int distance, Difficulty difficulty, EffortType effortType) {
        this.mDuration = duration;
        this.mDistance = distance;
        this.mDifficulty = difficulty;
        this.mEffortType = effortType;
    }

// Getters and Setters

    public SecondsDuration getmDuration() {
        return mDuration;
    }

    public void setmDuration(SecondsDuration mDuration) {
        this.mDuration = mDuration;
    }

    public int getmDistance() {
        return mDistance;
    }

    public void setmDistance(int mDistance) {
        this.mDistance = mDistance;
    }

    public Difficulty getmDifficulty() {
        return mDifficulty;
    }

    public void setmDifficulty(Difficulty mDifficulty) {
        this.mDifficulty = mDifficulty;
    }

    public EffortType getmEffortType() {
        return mEffortType;
    }

    public void setmEffortType(EffortType mEffortType) {
        this.mEffortType = mEffortType;
    }
}
