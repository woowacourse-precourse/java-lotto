package lotto.domain;

import static lotto.domain.LottoReference.NOPE;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoReference, Integer> lottoResult;

    public LottoResult(LottoMachine lottoMachine, LottoWithBonus lottoWithBonus) {
        this.lottoResult = calculateResult(lottoMachine, lottoWithBonus);
    }

    public Map<LottoReference, Integer> getValue() {
        return this.lottoResult;
    }

    private Map<LottoReference, Integer> calculateResult(LottoMachine lottoMachine,
            LottoWithBonus lottoWithBonus) {
        Map<LottoReference, Integer> result = new HashMap<>();
        Lotto myLotto = lottoWithBonus.getLotto();

        for (Lotto haveLotto : lottoMachine.getBuyLottoList()) {
            int count = isContains(haveLotto, myLotto);
            LottoReference lottoReference = NOPE;
            if (count == 5) {
                lottoReference = checkBonus(haveLotto, lottoWithBonus);
            }
            if (count != 5) {
                lottoReference = LottoReference.hasCorrectCount(count);
            }
            result.put(lottoReference,
                    result.getOrDefault(lottoReference, 0) + 1);
        }
        return result;
    }

    private LottoReference checkBonus(Lotto haveLotto, LottoWithBonus lottoWithBonus) {
        if (haveLotto.getLottoNumbers().contains(lottoWithBonus.getBonusNumber())) {
            return LottoReference.BONUS;
        }
        return LottoReference.FIVE;
    }

    private int isContains(Lotto haveLotto, Lotto myLotto) {
        int count = 0;
        for (Integer number : myLotto.getLottoNumbers()) {
            if (haveLotto.getLottoNumbers().contains(number)) {
                count += 1;
            }
        }
        return count;
    }
}
