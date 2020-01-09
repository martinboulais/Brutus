package com.cpe.brutus;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecognitionReceiver extends BroadcastReceiver {

    Context mContext;
    List<ActivityTransitionEvent> activityList = new ArrayList<ActivityTransitionEvent>();
    String toSend="";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(context !=null) {
            this.mContext = context;
        }

        if (ActivityTransitionResult.hasResult(intent)){
            ActivityTransitionResult result= ActivityTransitionResult.extractResult(intent);
            if (result != null){
                processTransitionResult(result);
            }
        }
    }



    public void processTransitionResult (ActivityTransitionResult result){
        for (ActivityTransitionEvent event : result.getTransitionEvents()){
            onDetectedTransition(event);
        }

    }


    private void onDetectedTransition (ActivityTransitionEvent activity){
        String ret ="activity= ";
        saveTransitionToSend(activity);
        switch(activity.getActivityType()){
            case DetectedActivity.ON_BICYCLE:
                this.activityList.add(activity);
                ret =ret + "velo";
                break;
            case DetectedActivity.IN_VEHICLE:
                ret =ret + "voiture";
                break;

            case DetectedActivity.WALKING:
                ret =ret + "marche";
                this.activityList.add(activity);
                break;

            case DetectedActivity.RUNNING:
                ret =ret + "course";
                this.activityList.add(activity);
                break;

            case DetectedActivity.STILL:
                ret =ret + "rien";
                this.activityList.add(activity);
                break;

            default:
                ret = ret +"unknown";
                break;
        }

    }

    private void saveTransitionToSend(ActivityTransitionEvent activity){
        ActivityRecognitionUtils utils = new ActivityRecognitionUtils();
        this.toSend=this.toSend+utils.createTransitionString(activity);
        System.out.println(this.toSend);

    }

}
