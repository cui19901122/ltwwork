package com.ltw.view;


import org.apache.cordova.DroidGap;

import android.os.Bundle;


public class AndroidworkActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        //Æô¶¯»­Ãæ
		super.setIntegerProperty("splashscreen",R.drawable.ic_launcher);
        
        super.loadUrl("file:///android_asset/www/html/login.html",1*1000);
        
    }
}