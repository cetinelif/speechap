package com.example.speechtotext;

import java.util.ArrayList;





import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	 protected static final int RESULT_SPEECH = 1;
	 
	    private ImageButton btnSpeak;
	    private TextView txtText;
	    private Button git;
	    private Bundle bundle;
	   private Intent intent1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intent1 = new Intent(getApplicationContext(),ContactListActivity.class);
		bundle = new Bundle();	
		
		 txtText = (TextView) findViewById(R.id.txtText);
		 
	        btnSpeak = (ImageButton) findViewById(R.id.speak);
	        git = (Button) findViewById(R.id.rehber_btn);
	 
	        
	        git.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					
					startActivity(intent1);
					
				}
			});
	        btnSpeak.setOnClickListener(new View.OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {
	 
	                Intent intent = new Intent(
	                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	 
	                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	                
	                txtText.setText("");
                  
	 
	                try {
	                	
	                    startActivityForResult(intent, RESULT_SPEECH);
	                    
	    				
	                    
	                    
	                    
	                } catch (ActivityNotFoundException a) {
	                    Toast t = Toast.makeText(getApplicationContext(),
	                            "Opps! Your device doesn't support Speech to Text",
	                            Toast.LENGTH_SHORT);
	                    t.show();
	                }
	            }
	        });
	 
	    }
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	 
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	 
	        switch (requestCode) {
	        case RESULT_SPEECH: {
	            if (resultCode == RESULT_OK && null != data) {
	 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                txtText.setText(text.get(0));
	                bundle.putString("icerik",txtText.getText().toString());
    				intent1.putExtras(bundle);
	            }
	            break;
	        }
	 
	        }
	    }
	}
