package lotto.domain.lottomachine.payment;

import lotto.domain.lottomachine.lottoticket.LottoTicketSystem;

import java.math.BigDecimal;

import static lotto.domain.lottomachine.messages.DomainErrorMessage.LESS_THAN_PRICE;
import static lotto.domain.lottomachine.messages.DomainErrorMessage.NON_MULTIPLE_OF_PRICE;
import static lotto.domain.lottomachine.messages.DomainErrorMessage.ZERO_DIVISOR;

public class Payment {
    private final static int ZERO = 0;
    private final int money;

    private Payment(int money) {
        validateAmount(money);
        this.money = money;
    }

    public static Payment from(int money) {
        return new Payment(money);
    }

    private void validateAmount(int money) {
        if (isLessThanPrice(money)) {
            throw new IllegalArgumentException(LESS_THAN_PRICE.getMessage());
        }
        if (isNotMultipleOfPrice(money)) {
            throw new IllegalArgumentException(NON_MULTIPLE_OF_PRICE.getMessage());
        }
    }

    private boolean isLessThanPrice(int number) {
        return number < LottoTicketSystem.TICKET_PRICE;
    }

    private boolean isNotMultipleOfPrice(int number) {
        return number % LottoTicketSystem.TICKET_PRICE != ZERO;
    }

    public int divideBy(int price) {
        validateDivisor(price);
        return money / price;
    }

    private void validateDivisor(int number) {
        if (isZero(number)) {
            throw new ArithmeticException(ZERO_DIVISOR.getMessage());
        }
    }

    private boolean isZero(int number) {
        return number == ZERO;
    }

    public BigDecimal createBigDecimal() {
        return BigDecimal.valueOf(money);
    }
}
