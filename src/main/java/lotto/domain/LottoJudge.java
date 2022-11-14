package lotto.domain;

import static lotto.domain.LottoReference.FIVE;
import static lotto.domain.LottoReference.NOPE;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.vo.BuyLottoList;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.LottoResult;
import lotto.domain.vo.LottoWithBonus;

public class LottoJudge {

    private LottoResult lottoResult;

    public LottoJudge(BuyLottoList buyLottoList, LottoWithBonus lottoWithBonus) {
        this.lottoResult = calculateResult(buyLottoList, lottoWithBonus);
    }

    public LottoResult getLottoResult() {
        return this.lottoResult;
    }

    private LottoResult calculateResult(BuyLottoList lottoMachine, LottoWithBonus lottoWithBonus) {
        Map<LottoReference, Integer> result = new HashMap<>();

        for (Lotto haveLotto : lottoMachine.getBuyLottoList()) {
            int count = getContainsCount(haveLotto, lottoWithBonus.getLotto());
            LottoReference reference = LottoReference.hasCorrectCount(count);
            if (reference == FIVE) {
                reference = checkBonus(haveLotto, lottoWithBonus);
            }
            result.put(reference, result.getOrDefault(reference, 0) + 1);
        }
        return new LottoResult(result);
    }

    private LottoReference checkBonus(Lotto haveLotto, LottoWithBonus lottoWithBonus) {
        if (haveLotto.getLottoNumbers().contains(lottoWithBonus.getBonusNumber())) {
            return LottoReference.BONUS;
        }
        return LottoReference.FIVE;
    }

    private int getContainsCount(Lotto haveLotto, Lotto myLotto) {
        int count = 0;
        for (Integer number : myLotto.getLottoNumbers()) {
            if (haveLotto.getLottoNumbers().contains(number)) {
                count += 1;
            }
        }
        return count;
    }
}
