package com.cpe.brutus.model;

import java.util.SortedMap;

/**
 * Effort type defines the kind of effort a challenge is, and the diverse steps.
 */
public class EffortType {

    /**
     * This attribute represent the intensity of the effort as a map defining the effort and the
     * percentage of the challenge at which it starts. For example, the element 0.2 => 3 tells that
     * when 20% of the challenge is done the intensity goes up to 3.
     */
    private SortedMap<Float, Integer> intensities;

    /**
     * Constructor
     *
     * @param intensities the successive intensities for the effort
     */
    public EffortType(SortedMap<Float, Integer> intensities) {

        this.intensities = intensities;
    }
}
