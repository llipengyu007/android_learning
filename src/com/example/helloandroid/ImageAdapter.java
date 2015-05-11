package com.example.helloandroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter
{
	private Context m_Context;
	private Integer[] m_ImageIds=
	{
		R.drawable.ic_launcher,
		R.drawable.tmp,
		R.drawable.ic_launcher,
		R.drawable.quito1_sp
	};
	public ImageAdapter(Context c)
	{
		m_Context = c;
	}
	
	public int getCount()
	{
		return m_ImageIds.length;
	}
	
	public Object getItem(int position)
	{
		return position;
	}
	
	public long getItemId(int position)
	{
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView imageview = new ImageView(m_Context);
		
		imageview.setImageResource(m_ImageIds[position]);
		
		imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
		
		return imageview;
	}
}
