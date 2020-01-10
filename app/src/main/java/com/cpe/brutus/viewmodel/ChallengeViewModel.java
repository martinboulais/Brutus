package com.cpe.brutus.viewmodel;

import androidx.lifecycle.ViewModel;

import com.cpe.brutus.model.Challenge;
import com.cpe.brutus.model.ChallengeView;
import com.cpe.brutus.model.Difficulty;
import com.cpe.brutus.model.EffortType;
import com.cpe.brutus.model.SecondsDuration;

/**
 * ViewModel wraping a challengeView
 */
public class ChallengeViewModel extends ViewModel {

    /**
     * The challengeView this viewmodel wraps
     */
    private ChallengeView challengeView;

    /**
     * The challengeView title
     */
    private String title;

    /**
     * Constructor
     *
     * @param duration the duration of the wrapped challengeView
     * @param distance the distance of the wrapped challengeView
     * @param difficulty the difficulty of the wrapped challengeView
     * @param effortType the type of the effort of the wrapped challengeView
     */
    public ChallengeViewModel(
            String title,
            SecondsDuration duration,
            int distance,
            Difficulty difficulty,
            EffortType effortType
    ) {

        this.title = title;
        this.challengeView = new ChallengeView(duration, distance, difficulty, effortType);
    }

    /**
     * Constructor
     *
     * @param challengeView the challengeView we should wrap
     */
    public ChallengeViewModel(String title, ChallengeView challengeView) {

        this.title = title;
        this.challengeView = challengeView;
    }

    /**
     * Constructor
     *
     * @param challenge the challengeView we should wrap
     */
    public ChallengeViewModel(String title, Challenge challenge) {

        this.title = title;
        this.challengeView = new ChallengeView(challenge);
    }

    /**
     * Return the experience gain of the challengeView
     */
    public int getExperienceGain() {

        return this.challengeView.getDifficulty().getExperienceGain();
    }

// Getters and Setters

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        SecondsDuration duration = challengeView.getDuration();

        int hours = duration.getHours();
        int minutes = duration.getMinutes();
        int seconds = duration.getSeconds();

        String ret = "";

        if(hours > 0)
            ret += hours + "h ";

        if(minutes > 0 || (hours > 0 || seconds > 0))
            ret += minutes + "min";

        if(seconds > 0)
            ret += seconds + 's';

        return ret;
    }

    public String getDistance() {
        return Integer.toString(challengeView.getDistance());
    }

    public String getDifficulty() {
        return challengeView.getDifficulty().getLabel();
    }

    public EffortType getEffortType() {

        return challengeView.getEffortType();
    }
}
