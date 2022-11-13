package lotto.domain;

import static lotto.constants.LottoResult.NOPE;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import lotto.constants.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoWithBonus;

public class Compare {

    private LottoVendingMachine lottoVendingMachine;
    private LottoWithBonus lottoWithBonus;

    public Compare(LottoVendingMachine lottoVendingMachine, LottoWithBonus lottoWithBonus) {
        this.lottoVendingMachine = lottoVendingMachine;
        this.lottoWithBonus = lottoWithBonus;
    }


    public float calculateYield(Map<LottoResult, Integer> result) {
        long totalPrize = getTotalPrize(result);
        int price = lottoVendingMachine.getPrice();

        return (float) totalPrize / price * 100;
    }

    public long getTotalPrize(Map<LottoResult, Integer> result) {
        long totalPrize = 0L;
        for (LottoResult lo : LottoResult.values()) {
            if (lo != NOPE) {
                totalPrize += (long) lo.getPrize() * result.getOrDefault(lo, 0);
            }
        }
        return totalPrize;
    }


    public Map<LottoResult, Integer> getResult() {
        Map<LottoResult, Integer> result = new HashMap<>();
        Lotto myLotto = lottoWithBonus.getLotto();

        for (Lotto haveLotto : lottoVendingMachine.getHaveLottoList()) {
            int count = 0;
            count += isContains(haveLotto, myLotto);
            if (count == 5) {
                result.put(checkBonus(haveLotto, lottoWithBonus), result.getOrDefault(checkBonus(haveLotto, lottoWithBonus), 0) + 1);
            }
            if (count != 5) {
                result.put(LottoResult.hasCorrectCount(count), result.getOrDefault(LottoResult.hasCorrectCount(count), 0) + 1);
            }
        }
        return result;
    }

    private LottoResult checkBonus(Lotto haveLotto, LottoWithBonus lottoWithBonus) {
        if (haveLotto.getLottoNumbers().contains(lottoWithBonus.getBonusNumber())) {
            return LottoResult.BONUS;
        }
        return LottoResult.FIVE;
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
