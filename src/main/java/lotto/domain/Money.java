package lotto.domain;

import lotto.exception.ErrorCode;

public class Money {

    private int payment;

    public Money(String payment) {
        validWrite(payment);
        this.payment = Integer.parseInt(payment);
    }

    private void validWrite(String writePay) {
        if (!isDigit(writePay)) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isDigit(String write) {
        return write.chars().allMatch(Character::isDigit);
    }

    public int getPayment() {
        return payment;
    }
}
