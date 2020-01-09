package com.cpe.brutus;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.DetectedActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/***
 * Singletion to be sure to have an only instance of this class
 */
public class ActivityRecognitionUtils {

    private static ActivityRecognitionUtils instance;
    private long activityTime=0;

    private ActivityTransitionEvent currentActivity;
    private Date startCurrentActivity;

    public static ActivityRecognitionUtils getInstance() {
        if(ActivityRecognitionUtils.instance==null){
            ActivityRecognitionUtils.instance =new ActivityRecognitionUtils();
        }
        return ActivityRecognitionUtils.instance;
    }


    public String createTransitionString(ActivityTransitionEvent activity){
        String ret="";
        Date today = new Date();



        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.MEDIUM);
        //check if we have change the current activity
        if (newActivity(activity)){
            String activityType = activityToString(activity.getActivityType());
            String activityTransition = transitionToString(activity.getTransitionType());
            //New Activity
            ret = (activityTransition+" Activité: " + activityType + " à " + shortDateFormat.format(today));
            System.out.println(ret);
        }


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
            default:
                ret="unknown";
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
                ret="UNKNOWN";
                break;
        }
        return ret;
    }

    public boolean newActivity (ActivityTransitionEvent activity){
        boolean ret = false;
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.MEDIUM);
        if (this.currentActivity ==null){
            Date today = new Date();
            this.currentActivity=activity;
            this.startCurrentActivity = today;
            ret=true;
        }
        if (( this.currentActivity == null)|| activity.getActivityType() != this.currentActivity.getActivityType() ){
            Date today = new Date();

            try{
                SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                //Duration of the activity
                long duration = (SDF.parse(shortDateFormat.format(today)).getTime()) -
                        (SDF.parse(shortDateFormat.format(this.startCurrentActivity)).getTime());
                this.activityTime = duration/1000;
            }
            catch (Exception E){

            }
            System.out.println("FIN Activité: "+ this.currentActivity.getActivityType()+" Durée: "+this.activityTime);
            sendToLog(this.currentActivity.getActivityType(), shortDateFormat.format(this.startCurrentActivity), this.activityTime);
            this.currentActivity=activity;
            this.startCurrentActivity = today;
            ret=true;

        }
        return ret;
    }

    public void sendToLog (int activityType, String date, long duration){
        String toSend= "activity:"+activityType+" start:"+date+" duration:"+duration;

    }



}
