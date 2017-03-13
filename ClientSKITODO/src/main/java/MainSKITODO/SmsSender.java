package MainSKITODO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.verbs.TwiMLException;


public class SmsSender   {

	public static final String ACCOUNT_SID = "AC4810c31ddaa845e0a8fcca0ba52dcb22";
	  public static final String AUTH_TOKEN = "d04da88e58346ea8ac9db166496dcbb4";

	  public static void main(final String[] args) throws TwilioRestException, TwiMLException {

	    // Create a rest client
	    final TwilioRestClient client = new TwilioRestClient("AC4810c31ddaa845e0a8fcca0ba52dcb22", "d04da88e58346ea8ac9db166496dcbb4", "https://api-twilio-com-bucket_key.runscope.net");

	    // Get the main account (The one we used to authenticate the client)
	    final Account mainAccount = client.getAccount();

	    // Send an sms
	    final SmsFactory smsFactory = mainAccount.getSmsFactory();
	    final Map<String, String> smsParams = new HashMap<String, String>();
	    smsParams.put("To", "+21622088889"); // Replace with a valid phone number
	    smsParams.put("From", "(480) 771-9471"); // Replace with a valid phone number in your account
	    smsParams.put("Body", "This is a test message!");
	    smsFactory.create(smsParams);
	  }
}