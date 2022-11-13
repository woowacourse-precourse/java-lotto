package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.PurchaseAmount;

public class PurchaseLottos {

    private final List<PurchaseLotto> lottos;

    public PurchaseLottos(int quantity) {
        lottos = new ArrayList<>(quantity);

        for (int count = 0; count < quantity; ++count) {
            lottos.add(new PurchaseLotto());
        }
    }

    public PurchaseAmount calculateAmount() {
        return new PurchaseAmount(lottos.size() * 1000);
    }

}
