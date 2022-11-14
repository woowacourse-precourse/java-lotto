package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Lottos lottos;
    private Money money;

    public User(int money) {
        this.money = Money.of(money);
    }

    public void buyLotto() {
        this.lottos = createLottoByCount();;
    }

    public Money getMoney() {
        return money;
    }

    private Lottos createLottoByCount() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < getLottoCount(); i++) {
            lottos.add(Lotto.generateLottoAuto());
        }
        return new Lottos(lottos);
    }

    public int getLottoCount() {
        return money.exchangeLotto();
    }

}
