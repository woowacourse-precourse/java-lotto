package lotto;

import lotto.view.ErrorMessage;

public class Pay {
    private final int payNum;

    public Pay(String pay) {
        validate(pay);
        int payment = Integer.parseInt(pay);
        dividable(payment);
        this.payNum = payment/1000;
    }

    private void validate(String pay){
        for (int index = 0; index < pay.length(); index++) {
            int eachChar = pay.charAt(index);
            if (!Character.isDigit(eachChar)) {
                throw new IllegalArgumentException(ErrorMessage.numberType.getValue());
            }
        }
    }
    private void dividable(int pay) {
        if ( pay % 1000 != 0 ){
            throw new IllegalArgumentException(ErrorMessage.numberMultiple.getValue());
        }
    }
}

