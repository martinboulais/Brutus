package com.cpe.brutus;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.DetectedActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ActivityRecognitionUtils {
    private static final ActivityRecognitionUtils ourInstance = new ActivityRecognitionUtils();

    public static ActivityRecognitionUtils getInstance() {
        return ourInstance;
    }


    public String createTransitionString(ActivityTransitionEvent activity){
        String ret="";
        String activityType = activityToString(activity.getActivityType());
        ret = ("Activité: " + activityType + " à " + SimpleDateFormat.getDateTimeInstance());

        return ret;

    }

    public String activityToString(int activity){
        String ret="";
        System.out.println("detected");
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
        

        }
        System.out.println(ret);
        return ret;
    }



}
