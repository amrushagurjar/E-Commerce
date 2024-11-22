package apitestime.example.demo.paymentGateway;


import com.razorpay.PaymentLink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import java.time.Instant;

@Service("razorpayPaymentGateway")
public class RazorpayPaymentGateway implements PaymentGatway{
    @Value("${razorpay.key.id}")
    String username;

    @Value("${razorpay.key.secret}")
    String secretKey;

    public   RazorpayClient razorpay;

 public    RazorpayPaymentGateway(RazorpayClient  razorpay ){
     this.razorpay = razorpay;
 }
    @Override
    public String GeneratePaymentLink(int id, String name, int amount) throws RazorpayException {
       // RazorpayClient razorpay = new RazorpayClient(username, secretKey);
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", Instant.now().getEpochSecond() + 1000);
        paymentLinkRequest.put("reference_id","TS1989");
        paymentLinkRequest.put("description","Payment for Amrusha Initiated");
        JSONObject customer = new JSONObject();
        customer.put("name","+917225835374");
        customer.put("contact","Gaurav Kumar");
        customer.put("email","gaurav.kumar@example.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");
        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }

    @Override
    public boolean validatePayment(int orderID) {
        return false;
    }
}
