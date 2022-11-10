package lotto.domain;

public class Money {

    private int money;

    public Money(int money) {
        validateUnit(money);
        this.money = money;
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해주세요");
        }
    }

}
