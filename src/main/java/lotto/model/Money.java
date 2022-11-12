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

    private void validateNumber(String purchase){
        if(!purchase.matches(REGEX)){
            System.out.println("[ERROR] 1~45까지의 숫자를 입력해주세요");
            throw new NoSuchElementException();
        }
    }

    public int howMany(String purchase){
        return Integer.parseInt(purchase)/1000;
    }
}