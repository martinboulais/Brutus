package com.cpe.brutus.model;

import java.io.Serializable;

/**
 * This class keep a track of each data for the user, such as its level, experience...
 */
public class User implements Serializable {

    /**
     * The id is the unique identifier of the user for the backend and the app
     */
    private int mId;

    /**
     * The name of the user (displayed on the app)
     */
    private String mName;

    /**
     * The RPG level composant manager, to carry level and experience
     */
    private LevelManager levelManager;

    /**
     * Constructor
     *
     * @param id the mId of the user
     * @param experience the experience of the user
     * @param level the level of the user
     */
    public User(int id, int experience, int level) {

        levelManager = new LevelManager(experience, level);
        this.mId = id;
    }

    /**
     * Add a certain amount of experience to the current amount, and level up if needed
     *
     * @param experienceGained the amount of experience gained
     */
    public void gainExperience(int experienceGained) {

        levelManager.gainExperience(experienceGained);
    }

    // Getters and Setters

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getExperience() {

        return levelManager.getExperience();
    }

    public int getLevel() {

        return levelManager.getLevel();
    }
}

