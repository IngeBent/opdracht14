package com.example.android;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MyJscriptHandler {

	Context mContext;

	MyJscriptHandler(Context c){
	 mContext = c;
	}

	@JavascriptInterface
	public void sayhello(String toast)
	{
	 Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	}

	
}



