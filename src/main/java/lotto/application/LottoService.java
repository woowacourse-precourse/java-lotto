package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.infrastructure.LottoProvider;

public class LottoService {

    public static List<Lotto> getLottos(int purchaseAmount) {
        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);
        return LottoProvider.createLottos(lottoAmount.getLottoCount());
    }

}
