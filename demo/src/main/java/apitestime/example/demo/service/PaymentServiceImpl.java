package apitestime.example.demo.service;
import apitestime.example.demo.paymentGateway.PaymentGatway;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements  PaymentService {
    PaymentGatway paymentGatway;
   public  PaymentServiceImpl(@Qualifier("razorpayPaymentGateway")PaymentGatway paymentGatway){
         this.paymentGatway = paymentGatway;
   }


    public String initiatePayment(int amount, String name, int id) throws RazorpayException {

       return  paymentGatway.GeneratePaymentLink(amount , name , id);
       }
}
