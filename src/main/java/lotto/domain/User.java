package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Lottos lottos;
    private Money money;

    public User(int money) {
        this.money = new Money(money);
    }

    public void buyLotto() {
        List<Lotto> lottos = createLottoByCount();
        this.lottos = new Lottos(lottos);
    }

    private List<Lotto> createLottoByCount() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < getLottoCount(); i++) {
            lottos.add(Lotto.generateLottoAuto());
        }
        return lottos;
    }

    public int getLottoCount() {
        return money.exchangeLotto();
    }

}
