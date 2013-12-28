package com.example.speechap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class Message extends Activity{
	private Button getnum;
    private EditText writenum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		writenum = (EditText) findViewById(R.id.editText1);
		getnum = (Button) findViewById(R.id.button1);
	}
    
    
    

}
