package com.cpe.brutus;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.DetectedActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivityRecognitionUtils {
    private static final ActivityRecognitionUtils ourInstance = new ActivityRecognitionUtils();

    public static ActivityRecognitionUtils getInstance() {
        return ourInstance;
    }


    public String createTransitionString(ActivityTransitionEvent activity){
        String ret="";
        Date aujourdhui = new Date();

        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        String activityType = activityToString(activity.getActivityType());
        String activityTransition = transitionToString(activity.getTransitionType());
        ret = (activityTransition+" Activité: " + activityType + " à " + shortDateFormat.format(aujourdhui));

        return ret;

    }
    public String transitionToString(int activity){
        String ret="";
        switch(activity){
            case 0:
                ret="Start ";
                break;
            case 1:
                ret="End ";
                break;
        }
        return ret;
    }

    public String activityToString(int activity){
        String ret="";
        switch(activity){
            case DetectedActivity.ON_BICYCLE:
                ret="ON_BICYCLE";
                break;
            case DetectedActivity.IN_VEHICLE:
                ret="IN_VEHICLE";
                break;
            case DetectedActivity.WALKING:
                ret="WALKING";
                break;
            case DetectedActivity.RUNNING:
                ret="RUNNING";
                break;
            case DetectedActivity.STILL:
                ret="STILL";
                break;
            default:
                break;
        }
        return ret;
    }



}
