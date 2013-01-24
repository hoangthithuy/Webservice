package com.example.posii_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;




import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Client extends Activity {
 Button btnconnect;
 TextView txtView;
 String finalText = "";
 int notificationId=1;
 NotificationManager notificationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_client);
		btnconnect=(Button)findViewById(R.id.btnConnect);
		txtView=(TextView)findViewById(R.id.txtText);
		// hic
	}
  public void btnClick( View v)
  {
	  new Connection().execute();
	 
  }
  class Connection extends AsyncTask<Void,Void, Void>
  {
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub		
		connect();	
		return null;	
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(finalText!="")
		 clickGo();
//		 txtView.append(finalText); 
	}
	  
  }
  public void clickGo()
	{
		String serName = Context.NOTIFICATION_SERVICE;
	    notificationManager=(NotificationManager)getSystemService(serName);
		int icon=R.drawable.btn_star_big_on_selected;
//		String tickerText="";
		long when= System.currentTimeMillis();
		Notification notification=new Notification(icon,null,when);
		String extendedTitle="click receiver to update database";
		String extendedText="have some thing is modified in database";
//		Intent intent=new Intent(getApplicationContext(),NotifyHelper.class);
//		intent.putExtra("extendedText", extendedText);
//		intent.putExtra("extendedTitle", extendedTitle);
//		PendingIntent lauchIntent=PendingIntent.getActivity(getApplicationContext(), 0,intent, 0);
		notification.sound=Uri.parse("file:///sdcard/notification/sounds.mp3");
		notification.setLatestEventInfo(getApplicationContext(),extendedTitle,extendedText, null);
		notificationId=1;
		notificationManager.notify(notificationId,notification);
		
	}
  public void clickReceiver(View v)
  {
	 notificationId=1;
     notificationManager.cancel(notificationId);
  	 txtView.setText(finalText);
  }
  private void connect()
  {
	  try { 
	        InetAddress serverAddr = InetAddress.getByName("192.168.1.13"); 
	        Log.d("TCP", "C: Connecting..."); 
	        Socket socket = new Socket(serverAddr, 4444); 
	        String message  = "thuy";
	        PrintWriter out = null;
	        BufferedReader in = null;

	        try { 
	            Log.d("TCP", "C: Sending: '" + message + "'"); 
	            out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true); 
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));                
	            out.println(message);
	            String text = "";
	              finalText = "";
	            while ((text = in.readLine()) != null) {

	                finalText += text;
	                 }        
	            Log.d("TCP", "C: Sent."); 
	            Log.d("TCP", "C: Done.");               

	        } catch(Exception e) { 
	            Log.e("TCP", "S: Error", e); 
	        } finally { 
	            socket.close(); 
	        } 
          
	    } catch (UnknownHostException e) { 
	        // TODO Auto-generated catch block 
	        Log.e("TCP", "C: UnknownHostException", e); 
	        e.printStackTrace(); 
	    } catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        Log.e("TCP", "C: IOException", e); 
	        e.printStackTrace(); 
	    }    
  }
  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate thet menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.client_client, menu);
		return true;
	}

}
