package lotto.domain;

import lotto.LottoRank;
import lotto.view.OutputView;

import java.util.HashMap;

public class LottoStatics {
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

    public void print() {
        OutputView outputView = new OutputView();

        outputView.printWinStatics(rankStatics);
        outputView.printRateOfProfit(profitRate);
    }
}
