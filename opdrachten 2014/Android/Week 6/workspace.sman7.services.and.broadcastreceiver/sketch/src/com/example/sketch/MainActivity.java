package com.example.sketch;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

public class MainActivity extends Activity {

    private PowerBroadcastReceiver receiver;

	@Override
	protected void onStart() {
		super.onStart();
		
		IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
		broadcastManager.registerReceiver(receiver,filter);
	}


	@Override
	protected void onStop() {
		LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
		broadcastManager.unregisterReceiver(receiver);
		
		super.onStop();
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        receiver = new PowerBroadcastReceiver();
    }

    class PowerBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context arg0, Intent intent) {
			String message = "Power is ";
			
			if(intent.getAction() == Intent.ACTION_POWER_CONNECTED) {
				message += "connected";	
			}
			else if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED) {
				message += "disconnected";
			}
			
			Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
		}
    }
    
}
