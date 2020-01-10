package com.cpe.brutus.model;

import java.io.Serializable;

public class LevelManager implements Serializable {

    /**
     * The current experience amount
     */
    private int experience;

    /**
     * The current level
     */
    private int level;

    /**
     * Constructor
     *
     * @param experience the initial experience amount
     * @param level the initial level
     */
    public LevelManager(int experience, int level) {

        this.experience = experience;
        this.level = level;
    }

    /**
     * Returns the amount of experience necessary to complete a level (a level is an integer)
     * based on https://stackoverflow.com/questions/6954874/php-game-formula-to-calculate-a-level-based-on-exp
     *
     * @param level the level for which we want to know the total experience
     *
     * @return int the experience amount
     */
    public static int levelTotalExperience(int level) {

        int factor = 25;

        return factor * level * (1 + level);
    }

    /**
     * Add a certain amount of experience to the current amount, and level up if needed
     *
     * @param experienceGained the amount of experience gained
     */
    public void gainExperience(int experienceGained) {

        int levelTotalExperience = LevelManager.levelTotalExperience(this.level);
        this.experience += experienceGained;

        if(this.experience >= levelTotalExperience) {

            this.experience -= levelTotalExperience;
            this.level ++;
        }
    }

    // Getters


    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }
}
