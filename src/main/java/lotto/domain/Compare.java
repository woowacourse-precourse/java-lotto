package lotto.domain;

import static lotto.model.LottoReference.NOPE;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import lotto.model.LottoReference;
import lotto.model.Lotto;
import lotto.model.LottoWithBonus;

public class Compare {

    private LottoVendingMachine lottoVendingMachine;
    private LottoWithBonus lottoWithBonus;

    public Compare(LottoVendingMachine lottoVendingMachine, LottoWithBonus lottoWithBonus) {
        this.lottoVendingMachine = lottoVendingMachine;
        this.lottoWithBonus = lottoWithBonus;
    }

    public void printResult(Map<LottoReference, Integer> result) {
        DecimalFormat moneyFormat = new DecimalFormat("###,###");
        DecimalFormat floatFormat = new DecimalFormat("###,###.#");

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoReference lo : LottoReference.values()) {
            if (lo != NOPE) {
                System.out.printf("%d개 일치%s (%s원) - %d개\n", lo.getCorrectCount(), lo.getMessage(),
                        moneyFormat.format(lo.getPrize()),
                        result.getOrDefault(lo, 0));
            }
        }

        System.out.printf("총 수익률은 %s%%입니다.\n", floatFormat.format(calculateYield(result)));
    }


    public float calculateYield(Map<LottoReference, Integer> result) {
        long totalPrize = getTotalPrize(result);
        int price = lottoVendingMachine.getPrice();

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

        for (Lotto haveLotto : lottoVendingMachine.getHaveLottoList()) {
            int count = 0;
            count += isContains(haveLotto, myLotto);
            if (count == 5) {
                result.put(checkBonus(haveLotto, lottoWithBonus),
                        result.getOrDefault(checkBonus(haveLotto, lottoWithBonus), 0) + 1);
            }
            if (count != 5) {
                result.put(LottoReference.hasCorrectCount(count),
                        result.getOrDefault(LottoReference.hasCorrectCount(count), 0) + 1);
            }
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
