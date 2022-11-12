package lotto.domain;

public class LottoQuantity {
    public static final int UNIT = 1000;
    private int money;
    private int quantity;

    LottoQuantity(int money) {
        this.money = money;
    }

    public void calculateQuantity() {
        quantity = money / UNIT;
    }

    public int getQuantity() {
        return quantity;
    }
}
