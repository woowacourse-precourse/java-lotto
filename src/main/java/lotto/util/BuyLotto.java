package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.input.Money;

import java.util.List;

public class BuyLotto {
    public List<Lotto> getLottos() {
        return lottos;
    }

    public Money getMoney() {
        return money;
    }

    List<Lotto> lottos;
    Money money;
    public BuyLotto(Money money) {
        this.money = money;
        for (int i = 0; i < availablePurchasesNumber(money.getMoney()); i++) {
            lottos.add(i, new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }
    private int availablePurchasesNumber (int money) {
        return money / 1000;
    }

}
