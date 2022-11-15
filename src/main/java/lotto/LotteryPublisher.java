package lotto;

import lotto.random.LottoNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class LotteryPublisher {
    public static final int LOTTO_PRICE = 1_000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LotteryPublisher(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> publishByPurchaseAmount(int purchaseAmount) {
        return publishByPublishCount(purchaseAmount / LOTTO_PRICE);
    }

    public List<Lotto> publishByPublishCount(int publishCount) {
        List<Lotto> result = new ArrayList<>();
        for (int count = 0; count < publishCount; count++) {
            result.add(publishOne());
        }
        return result;
    }

    public Lotto publishOne() {
        return new Lotto(lottoNumberGenerator.generate());
    }
}
