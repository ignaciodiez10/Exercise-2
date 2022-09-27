package com.eldarstr.eldar.api.verification;

import com.eldarstr.eldar.api.cards.Card;
import com.eldarstr.eldar.api.cards.ValidationOperation;
import com.eldarstr.eldar.api.models.PaymentData;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @PostMapping("/api/processpayment")
    @ResponseBody
    public PaymentData getProcessPayment(@RequestBody PaymentData payment){

        ValidationOperation validation = new ValidationOperation(payment.getAmount(), new Card(payment.getBrand()));
        validation.validateOperation();
        payment.setRate(validation.rateYMark());
        return payment;
    }
}
