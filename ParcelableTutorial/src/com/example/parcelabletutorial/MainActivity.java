package com.example.parcelabletutorial;

import android.os.Bundle;
import android.os.Parcel;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
//this tutorial is on parceables.  Parceables are used when you want to transfer objects
//from one intent to another
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Quake quake1=new Quake();
        quake1.setTitle("quake 1 title");
        quake1.setUpdated("quake 1 updated");
        
        Bundle bundle=new Bundle();
        bundle.putParcelable("quake", quake1);
        Intent intent=new Intent(this, ConsumeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
