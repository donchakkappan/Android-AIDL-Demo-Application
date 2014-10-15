package com.ges.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class SubtractService extends Service {

  @Override
  public void onCreate() {
    super.onCreate();
  }
  
  @Override
  public IBinder onBind(Intent intent) {

	  
	 return new ISubtractService.Stub() {
		
		@Override
		public int subract(int ValueFirst, int valueSecond) throws RemoteException {
			
			return ValueFirst-valueSecond;
			
		}
	};

  }

  @Override
  public void onDestroy() {
    super.onDestroy();
   
  }
}
