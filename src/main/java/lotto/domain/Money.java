package lotto.domain;

public class Money {
    private static final int UNIT = 1000;
    private final Integer money;

    public Money(String money) {
        validateDigit(money);
        validateUnit(money);
        this.money = Integer.parseInt(money);
    }

    private void validateDigit(String money) {
        for (int index = 0; index < money.length(); index++) {
            if (!Character.isDigit(money.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
            }
        }
    }

    private void validateUnit(String money) {
        if (Integer.parseInt(money) % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    public Integer getMoney() {
        return this.money;
    }
}
