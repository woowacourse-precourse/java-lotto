package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.PayMoneyException;

public class Money {

    private int payment;

    public Money(String payment) {
        validWrite(payment);
        this.payment = Integer.parseInt(payment);
    }

    private void validWrite(String writePay) {
        if (!isDigit(writePay)) {
            throw new PayMoneyException(ErrorCode.ERROR.getMessage() + " Money is Exception !!");
        }
    }

    private boolean isDigit(String write) {
        return write.chars().allMatch(Character::isDigit);
    }

    public int getPayment() {
        return payment;
    }

    public static Money of(String payment) {
        return new Money(payment);
    }
}
