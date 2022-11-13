package lotto;

import static lotto.Const.BILL;
import static lotto.ErrorPhrase.WRONG_PAY;
import static lotto.ErrorPhrase.WRONG_INPUT;


public class Customer {
    public Customer() {
    }

    public int buy(String pay) {
        validate(pay);
        return Integer.parseInt(pay) / BILL.getNumber();
    }

    public void validate(String pay) {
        isContainNumber(pay);
        isNotWrongPay(pay);
    }

    public void isContainNumber(String pay) {
        boolean wrongInput = false;

        for (int i = 0; i < pay.length(); i++) {
            char character = pay.charAt(i);

            if (!('0' <= character && character <= '9')) {
                wrongInput = true;
            }
        }

        if (wrongInput) {
            throw new IllegalArgumentException(WRONG_INPUT.toString());
        }
    }

    public void isNotWrongPay(String pay) {
        int stringToInt = Integer.parseInt(pay);

        if (stringToInt % BILL.getNumber() != 0) {
            throw new IllegalArgumentException(WRONG_PAY.toString());
        }
    }
}
