package com.example.speechap;

import java.util.ArrayList;
 
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.telephony.SmsManager;
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
    private TextView txtno;
    private TextView txtmsg;
    private Button gonder;
    
    private String msg;
    
    //yenilik
    
    
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        txtText = (TextView) findViewById(R.id.txtText);
        txtno=(TextView)findViewById(R.id.textView1);
        
        gonder=(Button)findViewById(R.id.button1);
 
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
 
        btnSpeak.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
 
                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                //recognizerIntent
 
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                 
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txtText.setText("");
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Succes",
                            Toast.LENGTH_SHORT);
                    t.show();
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        gonder.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String no=txtno.getText().toString();
				String sms=msg;
				sendSMS(no, sms);
				
			}
		});
 
    }
    
    /*
     * 
     * (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
   //requestCodes
        switch (requestCode) {
        case RESULT_SPEECH: {
            if (resultCode == RESULT_OK && null != data) {
 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
 
                txtText.setText(text.get(0));
                msg=text.get(0).toString();
            }
            
          
            break;
        }
 
        }
    }
    
    //sms gönderme fonksiyonu
    private void sendSMS(String telefonNo, String mesaj)
    {        
        PendingIntent pi = PendingIntent.getActivity(this, 0,
            new Intent(this, MainActivity.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(telefonNo, null, mesaj, pi, null);        
    }
}