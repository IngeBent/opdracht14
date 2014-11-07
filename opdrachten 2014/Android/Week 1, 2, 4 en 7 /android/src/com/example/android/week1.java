package com.example.android;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.example.android.R;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class week1 extends ActionBarActivity {

	//custom view
	TextView tv1;
	RatingBar rb1;
	
	//asynctask
	private ImageView downloadedImage;
	private ProgressDialog simpleWaitDialog;
	private String downloadUrl = "http://www.9ori.com/media/images/020fc9b7d4.jpg";
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_week1);
	        
	
	        
	        //custom view
	        tv1 = (TextView)findViewById(R.id.textView);
	        rb1 = (RatingBar)findViewById(R.id.ratingBar);
	        
	        rb1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
	        	
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    tv1.setText(String.valueOf(rating));
                }
            });
	        
	      //asynctask
	        Button imageDownLoaderButton = (Button) findViewById(R.id.downloadButton);
	        
	        downloadedImage = (ImageView) findViewById(R.id.imageView);
	        imageDownLoaderButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					new ImageDownLoader().execute(downloadUrl);
					
				}
	        });  
	}
	 
	//asynctask
	    private class ImageDownLoader extends AsyncTask<String, Void, Bitmap>{

			@Override
			protected Bitmap doInBackground(String... Params) {
				// TODO Auto-generated method stub
				return downloadBitmap(Params[0]);
				
			}
			
			@Override
			protected void onPreExecute(){
				simpleWaitDialog = ProgressDialog.show(week1.this, "Wait", "download");
			}
			
			@Override
			protected void onPostExecute(Bitmap result){    	 
	    	 downloadedImage.setImageBitmap(result);
	    	 simpleWaitDialog.dismiss(); 
			}
			
			
		     private Bitmap downloadBitmap(String url){
		    	 final DefaultHttpClient client = new DefaultHttpClient();
		    	 final HttpGet getRequest = new HttpGet (url);
		    	 
		    	 try{
		    		 HttpResponse response = client.execute(getRequest);
		    		 
		    		 final int statusCode = response.getStatusLine().getStatusCode();
		    		 
		    		 if(statusCode != HttpStatus.SC_OK){
		    			 return null;
		    		 }
		    		 
		    		 final HttpEntity entity = response.getEntity();
		    	 
		    		 
		    		 if(entity != null){
		    			 InputStream inputStream = null;
		    			 
		    			 try{
		    				 inputStream = entity.getContent();
		    				 final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
		    				 return bitmap;
		    			 } 
		    			 finally {
		    				 if(inputStream != null)
		    				 {
		    					 inputStream.close();
		    					 
		    				 }
		    				 entity.consumeContent();
		    			 }
		    		 
		    		
		    		 }
		    		 
		    	 } catch (Exception e){
		    		 getRequest.abort();
		    	 }
		    	 return null;
		     }

	    }
	    
	    
	    //custom view
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
	    
	/*    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.week1) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }*/
	    
}