package com.example.parcelabletutorial;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ConsumeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consume);
        Bundle b = getIntent().getExtras();
        try{
	        Quake q = b.getParcelable("quake");
	        String quakeTitle = q.getTitle();
	        String quakeUpdated= q.getUpdated();
	        
	        TextView title=(TextView)findViewById(R.id.title);
	        TextView updated=(TextView)findViewById(R.id.updated);
	        
	        title.setText(quakeTitle);
	        updated.setText(quakeUpdated);
        }catch(Exception e)
        {
        	Log.d("exception in getting bundle", e.toString() );
        }
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_consume, menu);
        return true;
    }
}
