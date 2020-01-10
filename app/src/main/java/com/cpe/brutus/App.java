package com.cpe.brutus;

import android.app.Application;
import android.content.Context;

/**
 * This is used to access resources from anywhere in the code. This workaround is from:
 * https://stackoverflow.com/questions/4391720/how-can-i-get-a-resource-content-from-a-static-context/4391811#4391811
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
