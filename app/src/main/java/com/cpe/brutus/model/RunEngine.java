package com.cpe.brutus.model;

import java.util.Date;

public class RunEngine {

    /**
     * The current challenge
     */
    public Challenge currentChallenge;

    /**
     * The time when the user started to run
     */
    public Date startingTime;

    /**
     * The current distance the user have done
     */
    public int currentDistance;

    /**
     * The state of the challenge, i.e. if the user has started to run, if the challenge is done...
     */
    public int currentState;

    /**
     * Constructor
     *
     * @param currentChallenge the challenge that should be launched
     */
    public RunEngine(Challenge currentChallenge) {

        this.currentChallenge = currentChallenge;
    }

    /**
     * The possible where that the run engine can be durring a challenge
     */
    public enum STATES {

        NOT_LAUNCHED,
        RUNNING,
        PAUSED,
        ABBANDONNED,
        ENDED
    }
}
