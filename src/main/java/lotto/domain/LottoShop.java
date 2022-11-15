package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int DIVIDED_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoShop(Money money) {
        int count = money.getMoney() / DIVIDED_PRICE;
        OutputView.printLottoCount(count);
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(new LottoGenerator().getLotto()));
        }
        OutputView.printLineBreak();
    }

    public List<Lotto> buyLotto() {
        return this.lottos;
    }
}
