package lotto;

import java.util.Map;

public class LottoResult {
    private static final double PERCENTAGE = 100.0;

    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult(Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int getCountOfLottoResult(LottoRank lottoRank) {
        return lottoResult.get(lottoRank);
    }

    public double getLottoYield(Lottos lottos) {
        int totalWinMoney = getLottoTotalMoney();

        return (double) totalWinMoney / lottos.getLottoPrice() * PERCENTAGE;
    }

    public int getLottoTotalMoney() {
        int totalWinMoney = 0;

        for (LottoRank lottoRank : lottoResult.keySet()) {
            if (lottoResult.get(lottoRank) > 0) {
                totalWinMoney += lottoRank.getWinnings();
            }
        }

        return totalWinMoney;
    }
}
