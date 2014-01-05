package com.example.speechtotext;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Anasayfa extends Activity {
	
	Button smsgonder;
	Button aramayap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anasayfa);
		
		smsgonder=(Button)findViewById(R.id.smsgonder_btn);
		aramayap=(Button)findViewById(R.id.aramayap_btn);
		
		smsgonder.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainActivity.class);
                startActivity(intent); 
				
			}
		});
		
		aramayap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
                intent.setClass(getApplicationContext(),AramaYap.class);
                startActivity(intent);
			}
		});
		
		
	
	}
	
	}
