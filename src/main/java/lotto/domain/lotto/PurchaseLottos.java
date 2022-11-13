package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {

    private final List<LottoWithBonusNum> lottos;

    public PurchaseLottos(int quantity) {
        lottos = new ArrayList<>(quantity);

        for (int count = 0; count < quantity; ++count) {
            lottos.add(new LottoWithBonusNum());
        }
    }
}
