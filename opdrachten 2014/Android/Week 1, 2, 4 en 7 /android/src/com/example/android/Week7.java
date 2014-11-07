package com.example.android;

import com.example.android.MyJscriptHandler;
import com.example.android.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class Week7 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_week7);
		 WebView webView = (WebView) findViewById(R.id.webView);
		

        webView.getSettings().setJavaScriptEnabled(true);
        
        webView.addJavascriptInterface(new MyJscriptHandler(this), "Android");
       
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://athena.fhict.nl/users/i241221/inge.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
       super.onOptionsItemSelected(item);
       switch(item.getItemId()){

       case R.id.week1:
    	   week1MenuItem();
    	   break;
       case R.id.week2:
    	   week2MenuItem();
    	   break;
       case R.id.week4:
    	   week4MenuItem();
    	   break;
       case R.id.week7:
    	   week7MenuItem();
    	   break;

       }
       return true;
       
    }
	
	
	public void week1MenuItem(){
    	
    	Intent intent= new Intent(this, week1.class);
    	startActivity(intent);
    	
    	}

    public void week2MenuItem(){
    	
    	Intent intent= new Intent(this, week2.class);
    	startActivity(intent);
    	
    	}
    
 public void week4MenuItem(){
    	
    	Intent intent= new Intent(this, Week4.class);
    	startActivity(intent);
    	
    	}
 public void week7MenuItem(){
    	
    	Intent intent= new Intent(this, Week7.class);
    	startActivity(intent);
    	
    	}
}
