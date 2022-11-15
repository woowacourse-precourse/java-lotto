package lotto;

import lotto.console.ErrorMessage;

public class Pay {
    private final int payNum;

    public Pay(String pay) {
        validate(pay);
        int payment = Integer.parseInt(pay);
        divisible(payment);
        this.payNum = payment / 1000;
    }

    private void validate(String pay) {
        for (int idx = 0; idx < pay.length(); idx++) {
            int eachChar = pay.charAt(idx);
            if (!Character.isDigit(eachChar)) {
                throw new IllegalArgumentException(ErrorMessage.numberType.getValue());
            }
        }
    }

    private void divisible(int pay) {
        if (pay % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.numberMultiple.getValue());
        }
    }
}

