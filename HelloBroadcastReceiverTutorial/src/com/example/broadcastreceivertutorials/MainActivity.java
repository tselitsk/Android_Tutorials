package com.example.broadcastreceivertutorials;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	//main steps for broadcast receivers
	//1. make a broadcast receiver class that does some action
	//2. make an intent filter that calls the action of the reciever.
	//3. register the receiver with an intentFilter.  
	//This makes it so that the receivers looks for intents with the same action
	//4. 
	
	private TestReceiver receiver;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Make an intentFilter that calls the action of a broadcast reciever
        IntentFilter intentFilter=new IntentFilter(TestReceiver.ACTION_RESP);
        receiver = new TestReceiver();
        
        //register the receiver with the intent filer
        this.registerReceiver(receiver, intentFilter);
       
        //make an intent with the same action as the broadcast receiver
        Intent broadcastIntent=new Intent(TestReceiver.ACTION_RESP);
        
        //broadcast the intent, which will be picked up by the intent filter
        broadcastIntent.putExtra("message", "hello Broadcast Receiver");
        this.sendBroadcast(broadcastIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    public class TestReceiver extends BroadcastReceiver{
    	//the receiver takes the string from the intent and puts it into a UI
    	 public static final String ACTION_RESP ="com.androidbook.intents.testbc";
		@Override
		public void onReceive(Context context, Intent intent) {
			String message=intent.getStringExtra("message");
			TextView textView=(TextView)findViewById(R.id.txt_input);
			textView.setText(message);
			
		}
    }
    
    
}
