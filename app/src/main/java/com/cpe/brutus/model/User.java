package com.cpe.brutus.model;

/**
 * This class keep a track of each data for the user, such as its level, experience...
 */
public class User {

    /**
     * The id is the unique identifier of the user for the backend and the app
     */
    private int id;

    /**
     * The name of the user (displayed on the app)
     */
    private String name;

    /**
     * The current experience amount of the user
     */
    private int experience;

    /**
     * The current level of the user
     */
    private int level;

    /**
     * Constructor
     *
     * @param id the id of the user
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * Add a certain amount of experience to the current amount, and level up if needed
     *
     * @param experienceGained the amount of experience gained
     */
    public void gainExperience(int experienceGained) {

        int levelTotalExperience = this.levelTotalExperience(this.level);
        this.experience += experienceGained;

        if(this.experience >= levelTotalExperience) {

            this.experience -= levelTotalExperience;
            this.level ++;
        }
    }

    /**
     * Returns the amount of experience necessary to complete a level (defined by an integer)
     * based on https://stackoverflow.com/questions/6954874/php-game-formula-to-calculate-a-level-based-on-exp
     *
     * @param level the level for which we want to know the total experience
     *
     * @return int the experience amount
     */
    private int levelTotalExperience(int level) {

        int factor = 25;

        return factor * level * (1 + level);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {

        return this.experience;
    }
}

