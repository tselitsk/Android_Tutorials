package com.example.fragmentstutorial;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;

public class BasicFragmentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_fragment);
        
        FragmentManager fm=getFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_content);
        
        if(fragment==null)
        {
        
        	FragmentTransaction ft=fm.beginTransaction();
        	ft.add(R.id.fragment_content, new BasicFragment());
        	ft.commit();
        	
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_basic_fragment, menu);
        return true;
    }
}
