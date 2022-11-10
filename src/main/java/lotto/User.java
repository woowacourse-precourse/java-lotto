package lotto;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int lottoNum;
    private int money;
    private int earn;


    public User(int money) {
        if (InputValidator.isInvalidMoneyUnit(money)) {
            throw new IllegalArgumentException();
        }

        this.money = money;
    }
}
