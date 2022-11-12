package lotto.model;

import java.util.NoSuchElementException;

public class Money {
    private final String purchase;
    private static final String REGEX="^[0-9]+$";

    public Money(String purchase){
        validateNumber(purchase);
        validateMoney(purchase);
        this.purchase = purchase;
    }


}