package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.purchasedLottos = sortAllLottos(lottos);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    private List<Lotto> sortAllLottos(List<Lotto> lottos) {
        List<Lotto> sortedLottos = new ArrayList<>();
        for (Lotto lotto: lottos) {
            sortedLottos.add(sortLotto(lotto));
        }

        return sortedLottos;
    }

    private Lotto sortLotto(Lotto lotto) {
        List<Integer> sortedNumbers = lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);

        return new Lotto(sortedNumbers);
    }
}
