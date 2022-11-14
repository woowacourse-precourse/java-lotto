package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    private void validate (int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
