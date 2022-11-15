package lotto.domain.ingame;

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
            throw new IllegalArgumentException("적절하지 않은 구입금액입니다.");
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getTicket() {
        return ticket;
    }

}
