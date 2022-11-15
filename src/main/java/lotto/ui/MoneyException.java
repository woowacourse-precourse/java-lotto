package lotto.ui;

public class MoneyException {
    public MoneyException(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}