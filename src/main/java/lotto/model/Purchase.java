package lotto.model;

public class Purchase {
    private static final int PRICE_PER_AMOUNT = 1_000;

    private final int amount;

    public Purchase(int number) {
        int money = validate(number);
        this.amount = money / PRICE_PER_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }

    private int validate(int number) {
        isMultipleOfThousand(number);
        return number;
    }

    private void isMultipleOfThousand(int number) {
        if (number % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입해야 합니다.");
        }
    }
}
