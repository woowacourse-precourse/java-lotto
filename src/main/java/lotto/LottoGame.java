package lotto;

import java.util.List;

public class LottoGame {
    public void buy(Money money) {
        Lotto.buy(money);
    }

    public List<Lotto> getLottos() {
        return Lotto.getLottos();
    }
}
