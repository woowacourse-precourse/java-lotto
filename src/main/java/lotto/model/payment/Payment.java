package lotto.model.payment;

public class Payment {
    private static final int TICKET_PRICE = 1000;
    private final int amount;

    public Payment(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public Payment(Payment oth) {
        this.amount = oth.amount;
    }

    public int getLottoCount() {
        return amount / TICKET_PRICE;
    }

    public int getAmount() {
        return amount;
    }

    private static void validate(int amount) {
        if(isNotPositive(amount)) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        } if(doesNotHaveChange(amount)) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private static boolean isNotPositive(int amount) {
        return amount <= 0;
    }

    private static boolean doesNotHaveChange(int amount) {
        return amount % TICKET_PRICE != 0;
    }
}
