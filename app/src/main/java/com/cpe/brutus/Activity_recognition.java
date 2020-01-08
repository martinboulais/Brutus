package com.cpe.brutus;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.DetectedActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Activity_recognition{

    List<ActivityTransition> transitions = new ArrayList<>();

    Context mContext;
    PendingIntent mPendingIntent;

    public void startTracking(Context context){
        this.mContext= context;

        launchTransitionsActivity();

    }

    public void stopTracking(){
        if(mContext != null && mPendingIntent != null){
            // myPendingIntent is the instance of PendingIntent where the app receives callbacks.
            Task<Void> task = ActivityRecognition.getClient(mContext)
                    .removeActivityTransitionUpdates(mPendingIntent);

            task.addOnSuccessListener(
                    new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void result) {
                            mPendingIntent.cancel();
                        }
                    }
            );

            task.addOnFailureListener(
                    new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Log.e("MYCOMPONENT", e.getMessage());
                        }
                    }
            );


        }
    }


    public void launchTransitionsActivity(){
        System.out.println("lauch");
        /*
        * create a list of ActivityTransition object
        * */
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.IN_VEHICLE)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.IN_VEHICLE)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.RUNNING)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.RUNNING)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.WALKING)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.WALKING)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.ON_BICYCLE)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.ON_BICYCLE)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.STILL)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                        .build()
        );
        this.transitions.add(
                new ActivityTransition.Builder()
                        .setActivityType(DetectedActivity.STILL)
                        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                        .build()
        );
        ActivityTransitionRequest request = new ActivityTransitionRequest(transitions);

        ActivityRecognitionClient activityRecognitionClient= ActivityRecognition.getClient(mContext);

        Intent intent = new Intent(mContext, ActivityRecognitionReceiver.class);

        mPendingIntent = PendingIntent.getBroadcast(mContext,0,intent,0);


        Task<Void> task = activityRecognitionClient
                .requestActivityTransitionUpdates(request, mPendingIntent);

        task.addOnSuccessListener(

                new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void result) {

                       // System.out.println(result.toString());
                    }
                }
        );

        task.addOnFailureListener(
                new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        // Handle error
                    }
                }
        );





    }



}
