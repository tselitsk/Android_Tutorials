package com.example.intentservicetutorial;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ResponseReceiver receiver;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //have to register the broadcastReceiver
        IntentFilter intentFilter=new IntentFilter(ResponseReceiver.ACTION_RESP);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver=new ResponseReceiver();
        registerReceiver(receiver, intentFilter);
        
        
        ///text processing
        EditText input=(EditText)findViewById(R.id.txt_input);
        //get the input text
        String msgInput=input.getText().toString();
        Intent msgIntent=new Intent(this, SimpleIntentService.class);
        msgIntent.putExtra(SimpleIntentService.PARAM_IN_MSG, msgInput);
        startService(msgIntent);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public class ResponseReceiver extends BroadcastReceiver {
   	 	public static final String ACTION_RESP =
   		      "com.mamlambo.intent.action.MESSAGE_PROCESSED";
   	
	   	@Override
	   	public void onReceive(Context context, Intent intent) {
	   		TextView result=(TextView)findViewById(R.id.txt_Result);
	   		String text=intent.getStringExtra(SimpleIntentService.PARAM_OUT_MSG);
	   		result.setText(text);
	   	}

   }
    
    
}
