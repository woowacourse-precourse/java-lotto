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
        System.out.printf("%d개를 구매했습니다.\n", wholeLotto.size());
        wholeLotto.forEach(System.out::println);
        System.out.println();
    }

    public List<Lotto> getWholeLotto() {
        return wholeLotto;
    }
}
