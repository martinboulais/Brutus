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
    List<String> activitylist = new ArrayList<String>();

    @Override
    public void onReceive(Context context, Intent intent) {
        if(context !=null) {
            this.mContext = context;
        }

        System.out.println("receive");
        if (ActivityTransitionResult.hasResult(intent)){
            ActivityTransitionResult result= ActivityTransitionResult.extractResult(intent);
            processTransitionResult(result);

        }
    }



    public void processTransitionResult (ActivityTransitionResult result){
        System.out.println("process");
        for (ActivityTransitionEvent event : result.getTransitionEvents()){
            onDetectedTransition(event);
        }

    }

    private void onDetectedTransition (ActivityTransitionEvent activity){
        System.out.println("detected");
        switch(activity.getActivityType()){
            case DetectedActivity.ON_BICYCLE:
                this.activitylist.add("velo");
                System.out.println("velo");
                break;
            case DetectedActivity.IN_VEHICLE:
                System.out.println("voiture");
                this.activitylist.add("voiture");
                break;
            case DetectedActivity.WALKING:
                System.out.println("marche");
                this.activitylist.add("marche");
                break;
            case DetectedActivity.RUNNING:
                System.out.println("course");
                this.activitylist.add("course");
                break;
            case DetectedActivity.STILL:
                System.out.println("rien");
                this.activitylist.add("rien");
                break;


        }
    }

    private void saveTransition(ActivityTransitionEvent activity){

    }

}
