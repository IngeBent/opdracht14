package com.example.android;



import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    
    
    public void aboutMenuItem(){
    	new AlertDialog.Builder(this)
    	.setTitle("about")
    	.setMessage("what do you want")
    	.setNeutralButton("ok", new DialogInterface.OnClickListener() {
    		
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub		
			}
		}).show();
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
    
    public void launcherMenuItem(){
    	new AlertDialog.Builder(this)
    	.setTitle("about")
    	.setMessage("what do you want")
    	.setNeutralButton("ok", new DialogInterface.OnClickListener() {
    		
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub		
			}
		}).show();
    	}
    
    
 
}
