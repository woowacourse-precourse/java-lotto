package lotto.domain;

import java.util.List;

public class User {
    private int money;
    private List<Lotto> lottos;

    public User() {
    }

    public void buy() {

    }

    private void validate() {

    }

    private void setMoney(int money) {
        this.money = money;
    }

    private void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
