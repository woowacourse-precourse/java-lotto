package lotto.domain.ingame;

import static lotto.util.Message.PAYMENT_INVALID_VALUE;

public class Payment {

    private final int amount;
    private final int ticket;
    private static final int LOTTO_PRICE = 1000;

    public Payment(int amount) {

        validate(amount);

        this.amount = amount;
        ticket = amount / 1000;
    }

    private void validate(int amount) {

        if (amount == 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PAYMENT_INVALID_VALUE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getTicket() {
        return ticket;
    }

}
