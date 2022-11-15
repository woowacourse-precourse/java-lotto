package lotto.domain;

import lotto.utils.LottoCompare;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> totalRank; // 각 등수에 대하여 몇 명씩 있는지
    private long totalPrice; // 구입한 로또의 총 금액
    private long totalPrizeMoney; // 구입한 로또에서 획득한 총 상금

    public LottoResult(LottoOrder lottoOrder, LottoAnswer lottoAnswer) {
        totalRank = LottoCompare.compareAllTickets(lottoOrder, lottoAnswer);
        totalPrice = (long) lottoOrder.getLottoCount() * 1000;
        totalPrizeMoney = calcTotalPrizeMoney();
    }

    /**
     * 구입한 로또에서 획득한 총 상금을 계산해서 반환
     *
     * @return 구입한 로또에서 획득한 총 상금
     */
    private long calcTotalPrizeMoney() {
        long result = 0L;

        for (LottoRank lottoRank : totalRank.keySet()) {
            result += (long) totalRank.get(lottoRank) * lottoRank.PRIZE_MONEY;
        }

        return result;
    }

    /**
     * 수익률에 해당하는 %를 소숫점 둘째자리에서 반올림하여 반환
     *
     * @return 수익률을 소숫점 둘째자리에서 반올림한 값의 문자열
     */
    public String getPriceEarningsRatio() {
        return String.format("%.1f", (double) totalPrizeMoney * 100 / totalPrice);
    }
}
