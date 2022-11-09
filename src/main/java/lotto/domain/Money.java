package lotto.domain;

public class Money {

    private static final String UNIT_OF_AMOUNT_ERROR = "[ERROR] 구매 금액은 1000원 단위로 입력 가능합니다.";
    private int money;

    public Money(int money) {
        this.money = validate(money);
    }

    public Money(String money) {
        this.money = validate(Integer.parseInt(money));
    }

    public int validate(int money) {
        if (money % 1000 == 0) {
            return money;
        }
        throw new IllegalArgumentException(UNIT_OF_AMOUNT_ERROR);
    }
}
