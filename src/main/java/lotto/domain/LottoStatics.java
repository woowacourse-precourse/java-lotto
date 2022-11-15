package lotto.domain;

import lotto.LottoRank;

import java.util.HashMap;
import java.util.StringJoiner;

public class LottoStatics {
    private final static String RATE_OF_PROFIT = "총 수익률은 %.1f%%입니다.";

    private final HashMap<LottoRank, Integer> rankStatics = new HashMap<>();
    private float profitRate;

    public LottoStatics() {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankStatics.put(lottoRank, 0);
        }
    }

    public void win(LottoRank lottoRank) {
        int currentRankCount = rankStatics.get(lottoRank);
        rankStatics.put(lottoRank, ++currentRankCount);
    }

    public void calculateProfitRate(int purchasePrice) {
        float profit = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            profit += rankStatics.get(lottoRank) * lottoRank.price;
        }
        float rateOfProfit = (profit / purchasePrice) * 100;

        profitRate =  Math.round(rateOfProfit * 10) / 10.0f;
    }

    public String getProfitRateResult() {
        return String.format(RATE_OF_PROFIT, profitRate);
    }

    public String getRankStaticsResult() {
        StringJoiner result = new StringJoiner("\n");
        for (LottoRank lottoRank : LottoRank.values()) {
            result.add(lottoRank.getResult(rankStatics.get(lottoRank)));
        }

        return result.toString();
    }
}
