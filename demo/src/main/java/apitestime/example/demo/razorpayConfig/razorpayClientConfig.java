package apitestime.example.demo.razorpayConfig;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class razorpayClientConfig {
    //@Value("${razorpay.key.id}")
   String username = "rzp_test_XCNaHMvVjuPPXY";

    //@Value("${razorpay.key.secret}")
    String secretKey = "a4YdB8WjYhawq3wSHFoHQflq";


    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient( username,secretKey );
    }
}
