package com.example.android;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Week4 extends ActionBarActivity {

	Animation fadeIn;
	ImageView imageView;
	AnimationDrawable rocketAnimation;
	AnimationDrawable lopenAnimation;
	AnimationDrawable roodwitAnimation;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_week4);
		
		
		
		TextView textView = (TextView) findViewById(R.id.textView1);
        fadeIn=AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeIn.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
				Toast.makeText(Week4.this, "Animation is done", Toast.LENGTH_SHORT).show();
				
			}
			
		});
        textView.startAnimation(fadeIn);
        
        
        /*ImageView rocketImage = (ImageView) findViewById(R.id.imageView1);
        rocketImage.setBackgroundResource(R.drawable.bolletjes);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        
     
       
        rocketAnimation.start();*/
        
        
        ImageView roodwitImage = (ImageView) findViewById(R.id.roodwit);
        roodwitImage.setBackgroundResource(R.drawable.roodwit);
        roodwitAnimation = (AnimationDrawable) roodwitImage.getBackground();
        
     
       
        roodwitAnimation.start();
      
        
        
        
        
        
        
        imageView = (ImageView) findViewById(R.id.imageView2);
 
        RotateAnimation animation = new RotateAnimation(10f,350f,15f,15f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(700);
        
        imageView.startAnimation(animation);
        
        
        
        imageView = (ImageView) findViewById(R.id.imageView3);
        
        RotateAnimation animation2 = new RotateAnimation(10f,350f,15f,15f);
        animation2.setInterpolator(new LinearInterpolator());
        animation2.setRepeatCount(Animation.INFINITE);
        animation2.setDuration(700);
        
        imageView.startAnimation(animation2);
        
        
        
        imageView = (ImageView) findViewById(R.id.imageView4);
        
        RotateAnimation animation3 = new RotateAnimation(10f,350f,15f,15f);
        animation3.setInterpolator(new LinearInterpolator());
        animation3.setRepeatCount(Animation.INFINITE);
        animation3.setDuration(700);
        
        imageView.startAnimation(animation3);
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
