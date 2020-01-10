package com.cpe.brutus.model;

public class UserView {

    /**
     * The user this view represents
     */
    private User mUser;

    /**
     * Constructor
     *
     * @param user the user this view represents
     */
    public UserView(User user) {

        mUser = user;
    }

    // Getters

    public String getName() {

        return mUser.getName();
    }

    public int getExperience() {

        return mUser.getExperience();
    }

    public int getLevel() {

        return mUser.getLevel();
    }
}
