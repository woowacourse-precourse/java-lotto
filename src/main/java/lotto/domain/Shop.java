package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final int PRICE = 1_000;

    private static final List<Lotto> lottos = new ArrayList<>();

    public Shop(Money money) {
        int count = money.getMoney() / PRICE;
    }

    public List<Lotto> buyLotto() {
        return this.lottos;
    }

}
