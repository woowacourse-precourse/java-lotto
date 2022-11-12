package lotto.domain;

public class PriceQuantity {
    public static final int UNIT = 1000;
    public static final String MONEY_ERROR_MESSAGE = "[ERROR]: " + UNIT + "원 단위가 아닙니다. \n";

    private int money;
    private int quantity;

    PriceQuantity(int money) {
        this.money = money;
        isValidateMoney(money);
        calculateQuantity();
    }

    public void calculateQuantity() {
        quantity = money / UNIT;
    }

    public int getQuantity() {
        return quantity;
    }

    public void isValidateMoney(int money) {
        if ((money < UNIT) || ((money % UNIT) != 0)) {
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
        }
    }
}
