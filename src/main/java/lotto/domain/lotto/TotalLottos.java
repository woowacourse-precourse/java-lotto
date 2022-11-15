package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class TotalLottos {
    static List<Lotto> totalLottos = new ArrayList<>();

    public TotalLottos(long lottoPurchaseCount) {
        for (int i = 0; i < lottoPurchaseCount; i++) {
            Lotto lotto = new Lotto(LottoNumbersMaker.makeLottoNumbers());
            totalLottos.add(lotto);
        }
    }

    public List<Lotto> getTotalLottos() {
        return totalLottos;
    }
}
