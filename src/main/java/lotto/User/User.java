package lotto.User;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Lotto> lottos;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public void buyLottos(int money) {

    }

    private boolean validateMoney(int money) {
        return money % 1000 == 0;
    }

    public void printLottos() {

    }

    public void printOneLotto() {

    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
