package com.example.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListener;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityImage extends ActionBarActivity {

	ImageView imageview;
	TextView textview;
	int image_alpha = 255;
	Handler mHandler = new Handler();
	
	ImageButton m_ImageButton1;
	ImageButton m_ImageButton2;
	boolean isrung = false;
	
	Button buttonNext, buttonPrev; 
	ImageView imageSwitch;
	int indexSwithc = 0;
	TextView textViewSwitch;
	private Integer[] m_ImageIds=
		{
			R.drawable.ic_launcher,
			R.drawable.tmp,
			R.drawable.ic_launcher,
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		
		/*******************image show*************************/
		isrung = true;
		
		imageview = (ImageView)findViewById(R.id.imageView1);
		textview = (TextView)findViewById(R.id.textView1);
		
		imageview.setAlpha(image_alpha);
		
		new Thread(new Runnable(){
			public void run()
			{
				while(isrung)
				{
					try{
					Thread.sleep(200);
					updateAlpha();
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		mHandler = new Handler(){
			public void handleMessage(Message msg)
			{
				super.handleMessage(msg);
				imageview.setAlpha(image_alpha);
				textview.setText("ALPHA: " + Integer.toString(image_alpha));
				imageview.invalidate();
			}
		};
		/********************************************/
		/*******************image button*************************/
		m_ImageButton1 = (ImageButton)findViewById(R.id.imageButton1);
		m_ImageButton2 = (ImageButton)findViewById(R.id.imageButton2);
		
		m_ImageButton1.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				Dialog dialog = new AlertDialog.Builder(ActivityImage.this)
					.setTitle("INFORTION: ")
					.setMessage("I AM BUTTON 1")
					.setPositiveButton("SURE", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							;
						}
					})
					.setNegativeButton("NOT",
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									;
								}
							}).create();
				
				dialog.show();
			}
		});
		
		m_ImageButton2.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				Dialog dialog = new AlertDialog.Builder(ActivityImage.this)
					.setTitle("INFORTION: ")
					.setMessage("I AM BUTTON 2")
					.setPositiveButton("SURE", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							;
						}
					}).create();
				
				dialog.show();
			}
		});
		/********************************************/
		
		/******************gallery*******************/
		Gallery m_Gallery = (Gallery)findViewById(R.id.gallery1);
		m_Gallery.setAdapter(new ImageAdapter(this));
		
		m_Gallery.setBackgroundResource(R.drawable.image);
		
		m_Gallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Toast.makeText(ActivityImage.this, "CHOICE:" + (position+1) + "IMAGE", Toast.LENGTH_SHORT).show();
			}
		});
		
		/********************************************/
		
		/********************switch image*************/
		imageSwitch = (ImageView) findViewById(R.id.imageViewSwitch);
		textViewSwitch = (TextView) findViewById(R.id.textViewSwitch);
		buttonNext = (Button) findViewById(R.id.buttonNext);
		buttonNext.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		indexSwithc++;
        		indexSwithc = indexSwithc < m_ImageIds.length ? indexSwithc : m_ImageIds.length-1;
        		imageSwitch.setImageResource(m_ImageIds[indexSwithc]);
        		
        		textViewSwitch.setTextColor(Color.BLUE);
        
        		textViewSwitch.setText("No. " + Integer.toString(indexSwithc+1));
        	}
        });
		buttonPrev = (Button) findViewById(R.id.buttonPrev);
		buttonPrev.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		indexSwithc--;
        		indexSwithc = indexSwithc >=0 ? indexSwithc : 0;
        		imageSwitch.setImageResource(m_ImageIds[indexSwithc]);
               	
            	textViewSwitch.setTextColor(Color.BLUE);
        	
        		textViewSwitch.setText("No. " + Integer.toString(indexSwithc+1));
        	}
        });
		
		/********************************************/
		
	}
	
	public void updateAlpha()
	{
		if(image_alpha - 7 >= 0){
			image_alpha -= 7;
			}else{
				image_alpha = 0;
				isrung = false;
			}
				
		mHandler.sendMessage(mHandler.obtainMessage());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_image, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id)
		{
		case R.id.back:
				Intent intent = new Intent();
	    	   intent.setClass(ActivityImage.this, Activity02.class);
	    	   startActivity(intent);
	    	   ActivityImage.this.finish();
	    	   break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
