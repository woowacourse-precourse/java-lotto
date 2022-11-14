package lotto.domain.ingame;

import lotto.exception.InvalidPaymentException;
import lotto.view.OutputView;

public class Payment {

    private final int amount;
    private final int ticket;
    private static final int LOTTO_PRICE = 1000;

    public Payment(int amount) {

        try {
            validate(amount);
        } catch (Exception exception) {
            OutputView.showError(exception);
            throw new IllegalArgumentException();
        }

        this.amount = amount;
        ticket = amount / 1000;
    }

    private void validate(int amount) {

        if (amount == 0 || amount % LOTTO_PRICE != 0) {
            throw new InvalidPaymentException();
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getTicket() {
        return ticket;
    }

}
