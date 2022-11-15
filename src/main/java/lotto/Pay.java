package lotto;

import lotto.view.ErrorMessage;

public class Pay {
    private final int payNum;

    public Pay(String pay) {
        validate(pay);
        int payment = Integer.parseInt(pay);
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
}

