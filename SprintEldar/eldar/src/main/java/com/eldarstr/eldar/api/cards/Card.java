package com.eldarstr.eldar.api.cards;

import java.math.BigDecimal;
import java.util.Date;

public class Card {
    public BigDecimal numCard;

    public String brand;

    public String cardHolder;

    public Date expirationDate;

    public Card (BigDecimal numCard, String brand, String cardHolder, Date expirationDate) {

        this.numCard = numCard;
        this.brand = brand;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    public Card (String brand){
        this.brand = brand;
    }

    public boolean isValid() {
        Date currentDate = new Date();
        return  currentDate.after(this.expirationDate);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCardholder() {
        return cardHolder;
    }

    public void setCardholder(String cardholder) {
        this.cardHolder = cardholder;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}


