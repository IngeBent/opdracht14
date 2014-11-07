package com.example.android;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class week2 extends ActionBarActivity {
	
	
	//FragmentActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);
        
        FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction transaction = fm.beginTransaction();
    	startFragment StartFragment = new startFragment();
    	
    	transaction.add(R.id.fragment_placeholder, StartFragment);
    	transaction.commit();
    	
    }
    
    public void onSelectFragment(View view){
    	Fragment newFragment;
    	
    	if(view == findViewById(R.id.btnStart)){
    		newFragment = new startFragment();
    	}
    	else if(view == findViewById(R.id.btnFragment1)){
    		newFragment = new fragment1();
    		
    	}
    	else if(view == findViewById(R.id.btnFragment2)){
    		newFragment = new fragment2();
    		
    	}
    	else
    	{
    		newFragment = new startFragment();
    	}
    
    	
    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	transaction.replace(R.id.fragment_placeholder, newFragment);
    	transaction.addToBackStack(null);
    	transaction.commit();
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

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
