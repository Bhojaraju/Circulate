package com.debug;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity 
{
	TextView tvResult;
	TextView tvPage;
	int count=1;
	ArrayList<String> list;
	Random rand;
	
	public void select(View view)
	{
		
		
		switch (view.getId()) 
		{
		case R.id.imagePrev:if(count>1)
							{
								tvResult.setText(list.get((count-1)));
								count=count-1;
								tvPage.setText("Page "+count);
							}
							break;
		case R.id.imageNext:
							if(count<(list.size()-1))
							{
								tvResult.setText(list.get((count+1)));
								count=count+1;
								tvPage.setText("Page "+count);
							}
			
							break;

		case R.id.imageRandom:
					

		   
		    		count= rand.nextInt((9-1) + 1) + 1;
		    		tvResult.setText(list.get(count)+"");
					
					tvPage.setText("Page "+count);
			
							break;
		default:
			break;
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=(TextView) findViewById(R.id.tvResult);
        tvPage=(TextView) findViewById(R.id.tvPage);
        rand= new Random();
        
        list=new ArrayList<String>();
		
		list.add("Java is not 100% object oriented because it does not support multiple inheritance.Java is not 100% OOP's,"
				+ " because it uses primitive data types");
		list.add("Anonymous class is a class defined inside a method without a name "
				+ "and is instantiated and declared in the same place and cannot have explicit constructors.");
		
		list.add("Wrapped classes are classes that allow primitive types to be accessed as objects");
		list.add("Verification of byte code is a step performed by the JVM before it runs any class file"
				+ " to ensure that the class file is structurally and conceptually correct as per the JVM specification");
		list.add("Strings in java are immutable");
		list.add("Every class in java extends from object class");
		list.add("toString() method is used to convert object into string");
		list.add("super keyword");
		list.add("implements");
		list.add("volatile");
    }
    
    @Override
    protected void onStart() 
    {
    	// TODO Auto-generated method stub
    	super.onStart();
    	tvResult.setText(list.get(count));
    	tvPage.setText("Page "+count);
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
