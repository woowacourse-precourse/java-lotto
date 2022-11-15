package lotto.domain.user;

import lotto.domain.lotto.LottoInfo;
import lotto.error.ErrorMsg;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int money;
    private final List<Lotto> lotto;

    public User(int money) {
        this.money = money;
        lotto = new ArrayList<>();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public int getMoney() {
        return money;
    }

    public void buyLotto(Lotto lotto){
        this.lotto.add(lotto);
    }
}
