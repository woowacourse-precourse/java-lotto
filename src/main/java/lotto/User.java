package lotto;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int lottoNum;
    private int money;
    private int earn;


    public User(int money) {
        validateMoney(money);

        this.money = money;
    }


    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
