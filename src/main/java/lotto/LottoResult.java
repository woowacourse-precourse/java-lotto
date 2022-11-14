package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult(Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
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
