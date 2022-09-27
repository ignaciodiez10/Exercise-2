package com.eldarstr.eldar.api.cards;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ValidationOperation {
    private final BigDecimal consumption;
    private final Card card;

    final static int MAX_CONSUMPTION = 1000;

    public ValidationOperation(BigDecimal consumption, Card card) {
        this.consumption =consumption;
        this.card = card;
    }

    public void validateOperation(){
        if(!isValidOperation()){
            throw new IllegalArgumentException("consumption is greater than 1000");
        }
    }


    public boolean isValidOperation() {
        return this.consumption.compareTo(BigDecimal.valueOf(MAX_CONSUMPTION)) < 0;
    }

    SimpleDateFormat convertYear = new SimpleDateFormat("yy");

    public BigDecimal rateYMark() {

        if (card.getBrand().equalsIgnoreCase("VISA")) {
            BigDecimal taxVisa = BigDecimal.valueOf(Double.parseDouble(convertYear.format(LocalDate.now().getYear())) / (double) (LocalDate.now().getMonthValue()/100));
            return this.consumption.multiply(taxVisa);
        }
        else if (card.getBrand().equalsIgnoreCase("AMEX")) {
            BigDecimal taxAmex = BigDecimal.valueOf(Double.parseDouble(convertYear.format(LocalDate.now().getMonthValue() * 0.1)) /100 );

            return this.consumption.multiply(taxAmex);
        }
        else if (card.getBrand().equalsIgnoreCase("NARA")) {
            BigDecimal taxNara = BigDecimal.valueOf(Double.parseDouble(convertYear.format(LocalDate.now().getDayOfMonth() * 0.5)) /100 );
            return this.consumption.multiply(taxNara);
        }else {
            throw new IllegalArgumentException("Brand not found");
        }
    }

}

