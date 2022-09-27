package com.eldarstr.eldar.api.models;

import java.math.BigDecimal;

public class PaymentData {
    private String brand;
    private BigDecimal amount ;
    public BigDecimal rate;

    public String getBrand() {
        return brand;
    }

    public BigDecimal getAmount() {
        return  amount;
    }
    public BigDecimal getRate(){
        return rate;
    }
    public void  setRate(BigDecimal rate){
        this.rate = rate;
    }
}


