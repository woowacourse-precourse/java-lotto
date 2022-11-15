package lotto.domain;

import static lotto.domain.LottoReference.FIVE;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.vo.BuyLotteries;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.LottoResult;
import lotto.domain.vo.LottoWithBonus;

public class LottoJudge {

    private final BuyLotteries buyLotteries;
    private final LottoWithBonus lottoWithBonus;

    public LottoJudge(BuyLotteries buyLotteries, LottoWithBonus lottoWithBonus) {
        this.buyLotteries = buyLotteries;
        this.lottoWithBonus = lottoWithBonus;
    }

    public LottoResult calculateResult() {
        Map<LottoReference, Integer> lottoResult = new HashMap<>();

        for (Lotto haveLotto : buyLotteries.getBuyLotteries()) {
            int containsCount = getContainsCount(haveLotto, lottoWithBonus.getLotto());
            LottoReference reference = LottoReference.hasCorrectCount(containsCount);
            if (reference == FIVE) {
                reference = checkBonus(haveLotto, lottoWithBonus);
            }
            lottoResult.put(reference, lottoResult.getOrDefault(reference, 0) + 1);
        }
        return new LottoResult(lottoResult);
    }

    private LottoReference checkBonus(Lotto haveLotto, LottoWithBonus lottoWithBonus) {
        if (haveLotto.getLottoNumbers().contains(lottoWithBonus.getBonusNumber())) {
            return LottoReference.BONUS;
        }
        return LottoReference.FIVE;
    }

    private int getContainsCount(Lotto haveLotto, Lotto myLotto) {
        int containsCount = 0;
        for (Integer number : myLotto.getLottoNumbers()) {
            if (haveLotto.getLottoNumbers().contains(number)) {
                containsCount += 1;
            }
        }
        return containsCount;
    }
}
