package com.example.speechtotext;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		
		// Thread hazýrlanýyor
        Thread thread = new Thread() {
 
            @Override
            public void run() {
 
                try {
                    synchronized (this) {
                        // Uygulama 4 saniye ayný ekranda bekliyor
                        wait(2000);
                    }
                } catch (InterruptedException e) {
 
                    // Hata yönetimi
 
                } finally {
 
                    finish();
 
                    // Yeni açýlmak istenen Intent
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),Anasayfa.class);
                    startActivity(intent);
 
                }
 
            }
        };
 
        // Thread baþlatýlýyor
        thread.start();
	}

		
		
}
	

