package com.example.helloandroid;

import android.R.string;
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
import android.widget.MultiAutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private void DisplayToast(CharSequence str)
	{
		Toast toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT); 
	    toast.setGravity(Gravity.TOP | Gravity.LEFT, 300, 500);
	    toast.show(); 
	}
	
	private TextView textview, m_TextView, m_textview3;
	private RadioGroup m_RadioGroup;
	private RadioButton m_Radio1, m_Radio2, m_Radio3;
	private TextView m_textViewShowBox;
	private CheckBox m_CheckBox1, m_CheckBox2, m_CheckBox3;
	private Spinner m_Spinner;
	
	private static final String[] m_Countries = {"O","A","B","AB","OTHER"};
	private static final String[] m_autoString = {"a2","a2b","ab","abc"};
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m_TextView = (TextView) findViewById(R.id.textView2);
        m_textview3 = (TextView) findViewById(R.id.textView3);
        /***************Radio Button Test************************/
        m_RadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        m_Radio1 = (RadioButton) findViewById(R.id.radioButton1);
        m_Radio2 = (RadioButton) findViewById(R.id.radioButton2);
        m_Radio3 = (RadioButton) findViewById(R.id.radioButton3);
        
        m_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId == m_Radio2.getId())
				{
//					DisplayToast("CORRECT");
					m_textview3.setTextColor(Color.RED);
					m_textview3.setText("CORRECT ANSWER");
				}
				else
				{
					m_textview3.setTextColor(Color.BLACK);
					DisplayToast("WRONG");
					m_textview3.setText("CORRECT ANSWER IS : 2");
				}
			}
		});
        /**********************************************************/
        
        /***************CheckBox Test************************/
        m_CheckBox1 = (CheckBox) findViewById(R.id.checkBox1);
        m_CheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
        m_CheckBox3 = (CheckBox) findViewById(R.id.checkBox3);
        m_textViewShowBox = (TextView) findViewById(R.id.textViewShowBOX);
        
        m_CheckBox1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        	{
        		m_textViewShowBox.setText("SHOW CHECK BOX:  " + m_CheckBox1.getText());
        	}
        });
        m_CheckBox2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        	{
        		m_textViewShowBox.setText("SHOW CHECK BOX:  " + m_CheckBox2.getText());
        	}
        });
        m_CheckBox3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        	{
        		m_textViewShowBox.setText("SHOW CHECK BOX:  " + m_CheckBox3.getText());
        	}
        });
        /**********************************************************/
        
        /***********************button setting***********/
        Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setTextSize(10);
        buttonSubmit.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		int num = 0;
        		if(m_CheckBox1.isChecked())
        			num++;
        		if(m_CheckBox2.isChecked())
        			num++;
        		if(m_CheckBox3.isChecked())
        			num++;
        		
        		m_textViewShowBox.setText("AMOUNT:  " + Integer.toString(num));
        	}
        });
        
        textview = (TextView)this.findViewById(R.id.textView1);
        textview.setTextColor(Color.BLUE);
        textview.setBackgroundColor(Color.RED);
        /**********************************************************/
      
        
        /*************************Spiner test*********************/
        m_Spinner = (Spinner) findViewById(R.id.spinner1);
        
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, m_Countries);
        adapter.setDropDownViewResource(android.R.layout.simple_gallery_item);
        m_Spinner.setAdapter(adapter);
        m_Spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        	{
        		DisplayToast(m_Countries[arg2]);
        		arg0.setVisibility(View.VISIBLE);
        	}
        	public void onNothingSelected(AdapterView<?> parent){;}
        });
        /**********************************************************/
        
        /******************AutoComplete TextView Test**************/
        ArrayAdapter<String> adapterAutoCom = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, m_autoString);
        
        AutoCompleteTextView m_AutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        m_AutoCompleteTextView.setAdapter(adapterAutoCom);
//        MultiAutoCompleteTextView mm_AutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
//        
//        mm_AutoCompleteTextView.setAdapter(adapterAutoCom);
//        mm_AutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        
        
    }
	
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
    	switch (keyCode)
    	{
    	case KeyEvent.KEYCODE_DPAD_CENTER:
    		DisplayToast("click CENTER");
    		break;
    	case KeyEvent.KEYCODE_DPAD_UP:
    		DisplayToast("click UP");
    		break;
    	case KeyEvent.KEYCODE_DPAD_DOWN:
    		DisplayToast("click DOWN");
    		break;
    	case KeyEvent.KEYCODE_DPAD_LEFT:
    		DisplayToast("click LEFT");
    		break;
    	case KeyEvent.KEYCODE_DPAD_RIGHT:
    		DisplayToast("click Right");
    	case KeyEvent.KEYCODE_BACK:
    		DisplayToast("click BACK");
    		break;
    	default:
    		DisplayToast("OTHERS");
        	break;
    	}
    	return super.onKeyDown(keyCode, event);
    }
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)
    {
    	DisplayToast("MULTIPLECLICK");
    	return super.onKeyMultiple(keyCode, repeatCount, event);
    }
//    public boolean onTouchEvent(MotionEvent event)
//    {
//    	int iAction = event.getAction();
//    	if(iAction == MotionEvent.ACTION_CANCEL)
//    	{
//    		DisplayToast("ACTION_CANCEL");
//    		return false;
//    	}
//    	if(iAction == MotionEvent.ACTION_DOWN)
//    	{
//    		DisplayToast("ACTION_DOWN");
//    		return false;
//    	}
//    	if(iAction == MotionEvent.ACTION_MOVE)
//    	{
//    		DisplayToast("ACTION_MOVE");
//    		return false;
//    	}
//    	
//    	int x = (int)event.getX();
//    	int y = (int)event.getY();
//    	
//    	DisplayToast("location : " + Integer.toString(x) + " , " + Integer.toString(y));
//    	return super.onTouchEvent(event);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//    	MenuInflater inflater = getMenuInflater();
//    	inflater.inflate(R.menu.main,menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /********************intent && menu****************************/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int item_id = item.getItemId();
       switch(item_id)
       {
       case R.id.date_time:
    	   Intent intent = new Intent();
    	   intent.setClass(MainActivity.this, Activity02.class);
    	   startActivity(intent);
    	   MainActivity.this.finish();
    	   break;
       case R.id.image:
    	   Intent intent2 = new Intent();
    	   intent2.setClass(MainActivity.this, ActivityImage.class);
    	   startActivity(intent2);
    	   MainActivity.this.finish();
    	   break;
       case R.id.exit:
    	   MainActivity.this.finish();
    	   break;
       }
       
       return true;
    }
    /*********************************************************/
}
