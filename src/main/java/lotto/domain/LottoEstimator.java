package lotto.domain;

import lotto.LottoRank;

import java.util.HashMap;
import java.util.List;

public class LottoEstimator {
    private final static int MIN_MATCH_NUMBERS = 3;
    private final WinningLotto winningLotto;
    private final HashMap<LottoRank, Integer> rankStatics = new HashMap<>();

    public LottoEstimator(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNumber);
        for (LottoRank lottoRank : LottoRank.values()) {
            rankStatics.put(lottoRank, 0);
        }
    }

    public void estimateLotteries(List<Lotto> lotteries) {
        lotteries.forEach(this::rankLotto);
    }


    private void rankLotto(Lotto lotto) {
        int matchCount = lotto.getMatchCountWith(winningLotto.numbers());
        boolean hasBonusNumber = lotto.hasBonusNumber(winningLotto.bonusNumber());

        if (matchCount < MIN_MATCH_NUMBERS) {
            return;
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.matchLottoRank(matchCount, hasBonusNumber)) {
                int currentRankCount = rankStatics.get(lottoRank);
                rankStatics.put(lottoRank, ++currentRankCount);
                return;
            }
        }
    }

    public float estimateRateOfProfit(int purchasePrice) {
        float profit = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            profit += rankStatics.get(lottoRank) * lottoRank.price;
        }
        float rateOfProfit = (profit / purchasePrice) * 100;

        return Math.round(rateOfProfit * 10) / 10.0f;
    }
}
