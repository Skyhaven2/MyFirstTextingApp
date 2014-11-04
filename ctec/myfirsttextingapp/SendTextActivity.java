package ctec.myfirsttextingapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.telephony.SmsManager;
import android.widget.*;

public class SendTextActivity extends Activity
{
	private Button SendButton;
	private EditText PhoneNumber;
	private EditText Message;
	private View currentView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_text);
		SendButton = (Button) findViewById(R.id.SendButton);
		PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
		Message = (EditText) findViewById(R.id.Message);
		
		setupListners(currentView);
	}
	
	public void setupListners(View currentView)
	{
		SendButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				try
				{
					String contact = PhoneNumber.getText().toString();
					String message = Message.getText().toString();
					sendSMS(contact, message);
					
					Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
					
				}
				catch(Exception currentException)
				{
					Toast.makeText(currentView.getContext(),  "message was not sent", Toast.LENGTH_LONG).show();
					Toast.makeText(currentView.getContext(),  currentException.getMessage(),  Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	private void sendSMS(String messageAddress, String messageContent)
	{
		SmsManager mySMSManager = SmsManager.getDefault();
		mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);
	}
	
}
