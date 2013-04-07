package com.example.fragmentstutorial;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class BasicFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		  View view = inflater.inflate(R.layout.fragment_layout, container,false);
		  Button button = (Button)view.findViewById(R.id.fragment_button);
		  button.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					Activity activity=getActivity();
					if(activity!=null){
						Toast.makeText(activity, "You just clicked a fragment", Toast.LENGTH_LONG).show();
					}
				}
			  
		  });
		  
		return view;
	}

	
	
	
}
