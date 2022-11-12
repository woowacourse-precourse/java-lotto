package lotto.domain;

public class PlayerMoney {
    static final int lottoPrice = 1000;

    private final int money;

    public PlayerMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
