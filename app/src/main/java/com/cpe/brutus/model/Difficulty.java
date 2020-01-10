package com.cpe.brutus.model;

import java.io.Serializable;

/**
 * The difficulty represents the difficulty of a challenge and tells the experience it gives
 */
public class Difficulty implements Serializable {

    /**
     * The label of the difficulty, such as "high", "medium", "easy"
     */
    private String label;

    /**
     * This value represents the amount of experience a challenge gives to a user when it complete
     * the challenge with this difficulty
     */
    private int experienceGain;

    /**
     * Constructor
     *
     * @param label the label of the difficulty
     * @param experienceGain the experience gained after completion
     */
    public Difficulty(String label, int experienceGain) {
        this.label = label;
        this.experienceGain = experienceGain;
    }

    // Getters

    public int getExperienceGain() {
        return experienceGain;
    }

    public String getLabel() {
        return label;
    }
}
