package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lottos) {
        sortAllLottos(lottos);
        this.purchasedLottos = lottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    private void sortAllLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            sortNumbers(lotto.getNumbers());
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
