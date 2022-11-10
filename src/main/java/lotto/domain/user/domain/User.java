package lotto.domain.user.domain;

import lotto.domain.lotto.domain.Lotto;

import java.util.List;

public class User {

    private final int money;
    private final List<Lotto> lottos;

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
