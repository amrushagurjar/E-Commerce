package apitestime.example.demo.controller;


import apitestime.example.demo.Dto.PaymentDto;
import apitestime.example.demo.service.PaymentServiceImpl;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PaymentController {
     @Autowired
     PaymentServiceImpl paymentService;

     @PostMapping("/payment")
    public  String   initiatePayment(@RequestBody  PaymentDto paymentDto) throws RazorpayException {
              return paymentService.initiatePayment(paymentDto.getAmount(),paymentDto.getName(), paymentDto.getId());
         }
}
