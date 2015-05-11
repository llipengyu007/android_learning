package com.example.helloandroid;

import java.util.Calendar;

import android.R.string;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TimePicker;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Activity02 extends ActionBarActivity {

	DatePicker m_DatePicker;
    TimePicker m_TimePicker;
    Button m_dpButton;
    Button m_tpButton;
    Calendar m_calendar;
    
	private void DisplayToast(CharSequence str)
	{
		Toast toast = Toast.makeText(Activity02.this, str, Toast.LENGTH_SHORT); 
	    toast.setGravity(Gravity.TOP | Gravity.LEFT, 300, 500);
	    toast.show(); 
	}
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        
        m_calendar = Calendar.getInstance();
        m_dpButton = (Button)findViewById(R.id.button2);
        m_tpButton = (Button)findViewById(R.id.button1);
        
        m_DatePicker = (DatePicker)findViewById(R.id.DatePicker1);
        m_DatePicker.init(m_calendar.get(Calendar.YEAR), m_calendar.get(Calendar.MONTH), m_calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				;//m_calendar.set(year, monthOfYear, dayOfMonth);
			}
		});
        
        m_TimePicker = (TimePicker)findViewById(R.id.TimePicker1);
        m_TimePicker.setIs24HourView(true);
        m_TimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
			}
		});
      
        m_dpButton.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v)
        	{
        		new DatePickerDialog(Activity02.this, 
        				new DatePickerDialog.OnDateSetListener() {
							@Override
							public void onDateSet(DatePicker view, int year, int monthOfYear,
									int dayOfMonth) {
								// TODO Auto-generate/d method stub
								m_DatePicker.updateDate(year, monthOfYear, dayOfMonth);
								
							}
						}
        		, m_calendar.get(Calendar.YEAR), m_calendar.get(Calendar.MONTH), m_calendar.get(Calendar.DAY_OF_MONTH)).show();
        	}
        });
        
        m_tpButton.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v)
        	{
        		new TimePickerDialog(Activity02.this, 
        				new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
								// TODO Auto-generate/d method stub
								m_TimePicker.setCurrentHour(hourOfDay);
								m_TimePicker.setCurrentMinute(minute);
							}
						}
        		, m_calendar.get(Calendar.HOUR_OF_DAY), m_calendar.get(Calendar.MINUTE), true).show();
        	}
        });
        
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int item_id = item.getItemId();
       switch(item_id)
       {
       case R.id.main:
    	   Intent intent = new Intent();
    	   intent.setClass(Activity02.this, MainActivity.class);
    	   startActivity(intent);
    	   Activity02.this.finish();
    	   break;
       case R.id.image:
    	   Intent intent2 = new Intent();
    	   intent2.setClass(Activity02.this, ActivityImage.class);
    	   startActivity(intent2);
    	   Activity02.this.finish();
    	   break;
    	   
       case R.id.exit:
    	   Activity02.this.finish();
    	   break;
       }
       
       return true;
    }
}
