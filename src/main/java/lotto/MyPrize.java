package lotto;

import lotto.constant.LottoInfo;
import lotto.constant.Rank;

public class MyPrize {
    // 총 5등까지 있으므로 크기 6짜리 배열
    // 1등은 인덱스 1, 5등은 인덱스 5를 가진다
    private int [] rankArr;
    private long profitAmount;

    private long [] fixedPrizeMoneyByRanking = {
            0,
            Rank.FIRST.getReward(),
            Rank.SECOND.getReward(),
            Rank.THIRD.getReward(),
            Rank.FOURTH.getReward(),
            Rank.FIFTH.getReward()
    };

    public MyPrize(int[] rankArr) {
        this.rankArr = rankArr;
        calculateProfitAmount(rankArr);
    }

    public int[] getRankArr() {
        return rankArr;
    }

    public long getProfitAmount() {
        return profitAmount;
    }

    private void calculateProfitAmount(int [] rankArr) {
        for(int i = 1; i<= LottoInfo.REWARD_RANK_COUNT; i++) {
            if(rankArr[i] > 0) {
                profitAmount = profitAmount + fixedPrizeMoneyByRanking[i] * rankArr[i];
            }
        }
    }
}
