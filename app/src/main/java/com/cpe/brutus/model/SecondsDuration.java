package com.cpe.brutus.model;

import java.io.Serializable;

/**
 * This class represent a duration
 *
 * The duration is internaly represented in seconds, minutes and hour : no shorter duration
 */
public class SecondsDuration implements Serializable {

    /**
     * The seconds of the duration
     */
    int seconds;

    /**
     * The minutes of the duration
     */
    int minutes;

    /**
     * The hours of the duration
     */
    int hours;

    /**
     * Constructor
     *
     * @param seconds the number of seconds (more than 60 will be converted to minutes)
     */
    public SecondsDuration(int seconds) {

        refreshInternalState(seconds, 0, 0);
    }

    /**
     * Constructor
     *
     * @param seconds the number of seconds (more than 60 will be converted to minutes)
     * @param minutes the number of minutes (more than 60 will be converted to hours)
     */
    public SecondsDuration(int seconds, int minutes) {

        refreshInternalState(seconds, minutes, 0);
    }

    /**
     * Constructor
     *
     * @param seconds the number of seconds (more than 60 will be converted to minutes)
     * @param minutes the number of minutes (more than 60 will be converted to hours)
     * @param hours the number of hours (no limit)
     */
    public SecondsDuration(int seconds, int minutes, int hours) {

        refreshInternalState(seconds, minutes, hours);
    }

    /**
     * Refresh the internal state
     *
     * @param seconds the number of seconds (more than 60 will be converted to minutes)
     * @param minutes the number of minutes (more than 60 will be converted to hours)
     * @param hours the number of hours (no limit)
     */
    public void refreshInternalState(int seconds, int minutes, int hours) {

        this.seconds = seconds % 60;
        minutes = minutes + (seconds - this.seconds) / 60;

        this.minutes = minutes % 60;
        hours = hours + (minutes - this.minutes) / 60;

        this.hours = hours;
    }

// Getters

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

}
