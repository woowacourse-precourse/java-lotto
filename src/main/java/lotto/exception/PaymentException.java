package lotto.exception;

public class PaymentException {

    private static final int LOTTO_PRICE = 1000;
    private static final String NOT_RIGHT_PAYMENT_COMMENT = "[ERROR] 금액은 1000으로 나누어 떨어지는 금액이어야 합니다.";

    public void validate(String price){
        if(isZero(price) || isNotDividedByThousand(price)) paymentNotAcceptableException();
    }

    private boolean isNotDividedByThousand(String price){
        return Long.parseLong(price) % LOTTO_PRICE != 0;
    }

    private boolean isZero(String price){
        return price.equals("0");
    }

    private void paymentNotAcceptableException(){
        throw new IllegalArgumentException(NOT_RIGHT_PAYMENT_COMMENT);
    }
}
