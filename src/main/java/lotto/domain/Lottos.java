package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final String NEW_LINE = "\n";

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(Money money) {
        purchaseRandomLottos(money);
    }

    private void purchaseRandomLottos(Money money) {
        int numberOfLottos = money.countAvailable(Lotto.PRICE);
        while (numberOfLottos > 0) {
            lottos.add(Lotto.creatRandom());
            numberOfLottos--;
        }
    }

    public static Lottos purchaseFor(Money money) {
        return new Lottos(money);
    }

    Lottos(Lotto... lottos) {
        Collections.addAll(this.lottos, lottos);
    }

    public int countTotal() {
        return lottos.size();
    }

    public LottoResult countNumberOfWins(WinningLotto winningLotto) {
        return LottoResult.of(lottos, winningLotto);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : lottos) {
            message.append(lotto).append(NEW_LINE);
        }
        return message.toString();
    }
}
