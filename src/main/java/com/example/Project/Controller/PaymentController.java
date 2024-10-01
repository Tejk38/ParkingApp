package com.example.Project.Controller;


import com.example.Project.Service.EmailService;
import com.example.Project.Service.PaymentService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PaymentController {



    private final PaymentService paymentService;

    @GetMapping("/payment")
    public String home() {
        return "Payment";
    }

    @PostMapping("/payment/create")
    public RedirectView createPayment(
            @RequestParam("method") String method,
            @RequestParam("amount") String amount,
            @RequestParam("currency") String currency,
            @RequestParam("description") String description
    ) {
        try {
            String cancelUrl = "http://localhost:8080/payment/cancel";
            String successUrl = "http://localhost:8080/payment/success";
            Payment payment = paymentService.createPayment(
                    Double.valueOf(amount),
                    currency,
                    method,
                    "sale",
                    description,
                    cancelUrl,
                    successUrl
            );

            for (Links links: payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return new RedirectView(links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            log.error("Error occurred:: ", e);
        }
        return new RedirectView("/payment/error");
    }

    @GetMapping("/payment/success")
    public RedirectView paymentSuccess(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId, HttpSession session
            ) {
        try {
            Payment payment = paymentService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {

//                EmailService.sendEmail((String) session.getAttribute("email"),"Booking Successful");

                return new RedirectView("/bookingspage");
            }
        } catch (PayPalRESTException e) {
            log.error("Error occurred:: ", e);
        }
        return new RedirectView("/bookingspage");
    }

    @GetMapping("/payment/cancel")
    public String paymentCancel() {
        return "paymentCancel";
    }

    @GetMapping("/payment/error")
    public String paymentError() {
        return "paymentError";
    }


}
