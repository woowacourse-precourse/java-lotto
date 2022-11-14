package lotto.domain;

public class Money {
    private static final String MONEY_NOT_DIVIDED_1000_ERROR = "[ERROR] 입력한 금액이 1,000원 단위로 나누어 떨어지지 않습니다.";
    private static final int MONEY_DIVIDED = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }
    public static void validate(int money) {
        if((money % MONEY_DIVIDED) != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_1000_ERROR);
        }
    }

    public int getMoney() {
        return this.money;
    }
}
