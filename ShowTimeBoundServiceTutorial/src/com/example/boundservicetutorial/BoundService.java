package com.example.boundservicetutorial;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BoundService extends Service {

	private final IBinder myBinder=new MyLocalBinder();
	
	@Override
	public IBinder onBind(Intent arg0) {
		return myBinder;
	}
	
	public String getCurrentTime()
	{
		SimpleDateFormat dateformat = 
        new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
		return (dateformat.format(new Date()));
	}
	
	public String addNumbers(int num1, int num2)
	{
		int addedNumber=num1+num2;
		String addedNumberString=String.valueOf(addedNumber);
		return addedNumberString;
		
	}
	
	public class MyLocalBinder extends Binder
	{
		BoundService getService()
		{
			return BoundService.this;
		}
	}

}
