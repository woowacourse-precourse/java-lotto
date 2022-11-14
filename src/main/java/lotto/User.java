package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Lotto> wholeLotto;

    public User() {
        this.wholeLotto = new ArrayList<>();
    }

    public int getNumberOfAvailableLotto(int cash) {
        return cash / 1000;
    }

    public void buyLotto(Lotto lotto) {
        wholeLotto.add(lotto);
    }

    public void showWholeLotto() {
        wholeLotto.forEach(System.out::println);
    }

    public List<Lotto> getWholeLotto() {
        return wholeLotto;
    }
}
