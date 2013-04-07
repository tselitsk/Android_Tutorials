package com.example.boundservicetutorial;

import com.example.boundservicetutorial.BoundService.MyLocalBinder;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
//This tutorial uses a bounded service to the time
public class MainActivity extends Activity {
	BoundService myService;
	boolean isBound;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this, BoundService.class);
        this.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void showTime(View view)
    {
    	 String currentTime = myService.getCurrentTime();
    	 TextView myTextView = (TextView)findViewById(R.id.myTextView);
    	 myTextView.setText(currentTime);
    }
    
    
    private ServiceConnection serviceConnection=new ServiceConnection()
    {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			MyLocalBinder binder=(MyLocalBinder)service;
			myService=binder.getService();
			isBound=true;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			isBound=false;
		}
    };
    
}
