package lotto.model;

public class Money {
    private static final int MIN_BUY_UNIT = 1_000;
    private static final String ERROR_UNIT = String.format("[ERROR] 최소 구매 단위는 %s원 입니다.", MIN_BUY_UNIT);

    private int money;

    public Money(int money) {
        validateUnit(money);
        this.money = money;
    }

    private void validateUnit(int money) {
        try {
            if (money % MIN_BUY_UNIT != 0) {
                throw new IllegalArgumentException(ERROR_UNIT);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getMoney() {
        return this.money;
    }
}
