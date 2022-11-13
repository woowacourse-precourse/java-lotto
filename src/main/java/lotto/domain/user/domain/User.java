package lotto.domain.user.domain;

import lotto.domain.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int money;
    private List<Lotto> lottos = new ArrayList<>();

    public User(int money, List<Lotto> lottos) {
        this.lottos = lottos;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
