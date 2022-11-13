package lotto.domain;

import static lotto.domain.LottoReference.NOPE;

import java.util.HashMap;
import java.util.Map;

public class Compare {

    private LottoMachine lottoMachine;
    private LottoWithBonus lottoWithBonus;

    public Compare(LottoMachine lottoMachine, LottoWithBonus lottoWithBonus) {
        this.lottoMachine = lottoMachine;
        this.lottoWithBonus = lottoWithBonus;
    }

    public float getYield(Map<LottoReference, Integer> result) {
        long totalPrize = getTotalPrize(result);
        int price = lottoMachine.getPrice();

        return (float) totalPrize / price * 100;
    }

    public long getTotalPrize(Map<LottoReference, Integer> result) {
        long totalPrize = 0L;
        for (LottoReference lo : LottoReference.values()) {
            if (lo != NOPE) {
                totalPrize += (long) lo.getPrize() * result.getOrDefault(lo, 0);
            }
        }
        return totalPrize;
    }


    public Map<LottoReference, Integer> getResult() {
        Map<LottoReference, Integer> result = new HashMap<>();
        Lotto myLotto = lottoWithBonus.getLotto();

        for (Lotto haveLotto : lottoMachine.getHaveLottoList()) {
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
