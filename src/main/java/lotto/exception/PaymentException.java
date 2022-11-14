package lotto.exception;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class PaymentException {

    private static final int LOTTO_PRICE = 1000;
    private static final String NOT_RIGHT_PAYMENT_COMMENT = "[ERROR] 금액은 1000으로 나누어 떨어지는 금액이어야 합니다.";

    public void validate(String price){
        if(isNotNumber(price) ||isZero(price) || isNotDividedByThousand(price)) paymentNotAcceptableException();
    }

    private boolean isNotNumber(String price){
        return !Pattern.matches("^[0-9]*$", price);
    }

    private boolean isNotDividedByThousand(String price){
        return Long.parseLong(price) % LOTTO_PRICE != 0;
    }

    private boolean isZero(String price){
        return price.equals("0");
    }

    private void paymentNotAcceptableException(){
        System.out.println(NOT_RIGHT_PAYMENT_COMMENT);
        throw new NoSuchElementException(NOT_RIGHT_PAYMENT_COMMENT);
    }
}
