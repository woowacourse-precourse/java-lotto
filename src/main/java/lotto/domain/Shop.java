package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Shop {
    private static final int PRICE = 1_000;

    private final List<Lotto> lottos = new ArrayList<>();

    public Shop(Money money) {
        int count = money.getMoney() / PRICE;
        OutputView.printLotteryCount(count);
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(new NumberGenerator().getNumbers()));
        }
        OutputView.enterLine();
    }

    public List<Lotto> buyLotto() {
        return this.lottos;
    }

}
