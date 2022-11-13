package lotto.input;

public class Purchase {

    private static final int PRICE_PER_AMOUNT = 1_000;

    private final int amount;

    public Purchase(String input) {
        int money = validate(input);
        this.amount = money / PRICE_PER_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }

    private int validate(String input) {
        int number = isNumber(input);
        isMultipleOfThousand(number);
        return number;
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private void isMultipleOfThousand(int number) {
        if (number % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입해야 합니다.");
        }
    }
}
