package lotto;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int lottoNum;
    private int money;
    private int earn;


    public User(String money) {
        if (InputValidator.isInvalidMoneyForm(money)) {
            throw new IllegalArgumentException();
        }

        this.money = Integer.parseInt(money);
    }
}
