package com.example.intentservicetutorial;

import com.example.intentservicetutorial.MainActivity.ResponseReceiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;

public class SimpleIntentService extends IntentService {
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";
	
	
	public SimpleIntentService(String name) {
		super("In Simple Intent Service");
	}

		@Override
		protected void onHandleIntent(Intent intent) {
		//retrieve message from intent from Actiom
			String msg=intent.getStringExtra("Simple Intent Service");
			SystemClock.sleep(30000);
			String resultTxt=msg+" "+"Date Formatting";
			
		//making a broadcast intent and sending back the processed output paramter
		Intent broadcastIntent=new Intent();
		broadcastIntent.setAction(ResponseReceiver.ACTION_RESP);
		broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
		broadcastIntent.putExtra(PARAM_OUT_MSG, resultTxt);
		sendBroadcast(broadcastIntent);
		
				
		}

}
