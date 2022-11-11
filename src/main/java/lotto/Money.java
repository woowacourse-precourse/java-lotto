package lotto;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        this.money = money;
        validate();
    }

    private int parse(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력할 수 있습니다.");
        }
    }

    private void validate() {
        validateNotNegative();
        validateMultipleOfLottoPrice();
    }

    private void validateNotNegative() {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
        }
    }

    private void validateMultipleOfLottoPrice() {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
