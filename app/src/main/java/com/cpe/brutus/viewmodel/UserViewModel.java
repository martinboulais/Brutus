package com.cpe.brutus.viewmodel;

import androidx.lifecycle.ViewModel;

import com.cpe.brutus.App;
import com.cpe.brutus.R;
import com.cpe.brutus.model.LevelManager;
import com.cpe.brutus.model.User;
import com.cpe.brutus.model.UserView;

/**
 * ViewModel wrapping a mUserView
 */
public class UserViewModel extends ViewModel {

    /**
     * The wrapped mUserView
     */
    private UserView mUserView;


    /**
     * Return a new instance of userViewModel
     *
     * @return the created instance
     */
    public static UserViewModel getInstance() {

        return new UserViewModel(null);
    }

    /**
     * Constructor
     *
     * @param userView the mUserView to wrap
     */
    public UserViewModel(UserView userView) {

        this.mUserView = userView;
    }

    /**
     * Return a formated level indicator, such as "Level 8"
     *
     * @return the well formated level
     */
    public String getLevelText() {

        return App.getContext().getResources().getString(
                R.string.level_display,
                mUserView.getLevel()
        );
    }

    /**
     * Return the current progress in the level, for example if the level need 200 experience to
     * level up and the user have currently 50 xp, this will return 25
     *
     * @return the percentage progression
     */
    public int getLevelProgression() {

        int experience = mUserView.getExperience();
        int maxExperience = LevelManager.levelTotalExperience(mUserView.getLevel());

        return 100 * experience / maxExperience;
    }

    // Getters and setters

    public void setUserView(UserView userView) {

        this.mUserView = userView;
    }

    public String getName() {

        return mUserView.getName();
    }

    public int getExperience() {

        return mUserView.getExperience();
    }

    public int getTotalExperience() {

        return LevelManager.levelTotalExperience(mUserView.getLevel());
    }

    public int getLevel() {

        return mUserView.getLevel();
    }

}
