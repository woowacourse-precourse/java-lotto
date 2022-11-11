package lotto.exception;

public class PaymentException {

    private static final int LOTTO_PRICE = 1000;

    public void validate(String price){

    }

    private boolean isNotDividedByThousand(String price){
        return Long.parseLong(price) % LOTTO_PRICE != 0;
    }

    private boolean isZero(String price){
        return price.equals("0");
    }

    private void paymentNotAcceptableException(){

    }
}
