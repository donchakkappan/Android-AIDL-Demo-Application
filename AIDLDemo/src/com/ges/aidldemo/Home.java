package com.ges.aidldemo;


import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class Home extends Activity {

	EditText firstNumber,secondNumber;
	Button ok;
	
	
	ISubtractService service;
	AddServiceConnection connection;
	
	
	 /**
	   * This is the class which represents the actual service-connection.
	   * It type casts the bound-stub implementation of the service class to our AIDL interface.
	   */
	  class AddServiceConnection implements ServiceConnection {

	    public void onServiceConnected(ComponentName name, IBinder boundService) {
	    	
	      service = ISubtractService.Stub.asInterface((IBinder) boundService);
	      		
	      Toast.makeText(Home.this, "AIDLExample Service connected", Toast.LENGTH_LONG).show();
	      
	    }

	    public void onServiceDisconnected(ComponentName name) {
	    	
	      service = null;
	      Toast.makeText(Home.this, "AIDLExample Service Connected", Toast.LENGTH_LONG).show();
	      
	    }
	    
	  }
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		initService();
		
		
		firstNumber=(EditText)findViewById(R.id.firstNumber);
		secondNumber=(EditText)findViewById(R.id.secondNumber);
		ok=(Button)findViewById(R.id.subtract);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				try {
					int a=Integer.parseInt(firstNumber.getText().toString());
					int b=Integer.parseInt(secondNumber.getText().toString());
					
					System.out.println(a+b);
					
					int c=service.subract(a,b);
					
					Toast.makeText(getApplicationContext(),c+"",Toast.LENGTH_SHORT).show();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		
	}
	
	
	  /** This is our function which binds our activity(MainActivity) to our service(AddService). */
	  private void initService() {
	
		connection = new AddServiceConnection();
	    Intent i = new Intent();
	    i.setClassName("com.ges.aidldemo",com.ges.aidldemo.SubtractService.class.getName());
	    @SuppressWarnings("unused")
		boolean isItConnected= bindService(i, connection, Context.BIND_AUTO_CREATE);

	  }

	  /** This is our function to un-binds this activity from our service. */
	  private void releaseService() {
	    unbindService(connection);
	    connection = null;

	  }
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		releaseService();
	}
	
}
