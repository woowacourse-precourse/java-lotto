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

    private void validateMoney(String purchase){
        if(Integer.parseInt(purchase)%1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }
}