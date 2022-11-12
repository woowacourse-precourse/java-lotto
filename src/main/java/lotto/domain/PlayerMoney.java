package lotto.domain;

import static lotto.domain.ErrorMessage.PLAYER_MONEY_ERROR_MESSAGE;

public class PlayerMoney {
    static final int lottoPrice = 1000;

    private final int money;

    public PlayerMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % lottoPrice != 0) {
            System.out.println(PLAYER_MONEY_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
