package apitestime.example.demo.paymentGateway;

import com.razorpay.RazorpayException;
import lombok.Getter;
import lombok.Setter;


public interface PaymentGatway   {
    public String GeneratePaymentLink(int id, String name ,int amount ) throws RazorpayException;
    public boolean validatePayment(int orderID);
}
