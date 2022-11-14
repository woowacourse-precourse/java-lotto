package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final int MIN_BUY_UNIT = 1_000;
    private List<Lotto> lottos;
    private int money;
    private int countLottos;

    public Buyer(Money money) {
        this.money = money.getMoney();
        this.countLottos = this.money / MIN_BUY_UNIT;
        buyLottos();
    }

    private void buyLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countLottos; i++) {
            lottos.add(Lotto.makeRandom());
        }
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}
