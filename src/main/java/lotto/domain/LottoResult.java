package lotto.domain;

import java.util.List;

public class LottoResult {

    private final List<lotto.domain.Rank> ranks;

    private final int investMoney;

    public LottoResult(List<lotto.domain.Rank> ranks, int investMoney) {
        this.ranks = ranks;
        this.investMoney = investMoney;
    }

    public double earningRate() {
        int earning = 0;
        for (lotto.domain.Rank rank : ranks) {
            earning += rank.prize();
        }
        return (double) earning / investMoney;
    }

    public List<lotto.domain.Rank> getRanks() {
        return ranks;
    }

}
