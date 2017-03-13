package MainSKITODO;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class ClientSKITODO {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "mohamed.mbarek@esprit.tn";
  public static final String AUTH_TOKEN = "mb.med22121991";

  public static void main(String[] args) {
    Twilio.init("mohamed.mbarek@esprit.tn", "mb.med22121991");

    Message message = Message.creator(new PhoneNumber("+21622088889"),
        new PhoneNumber("+21646209594"), 
        "SMS API TESTING !!!!!!!!"
        + "Hello everyone :) ").create();

    System.out.println(message.getSid());
    
    //added by hama
  }
}
