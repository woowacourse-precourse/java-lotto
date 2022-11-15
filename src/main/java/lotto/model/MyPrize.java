package lotto.model;

import lotto.constant.LottoInfo;
import lotto.constant.RankInfo;

public class MyPrize {
    // 총 5등까지 있으므로 크기 6짜리 배열
    // 1등은 인덱스 1, 5등은 인덱스 5를 가진다
    private int [] rankArr;
    private long profitAmount;

    public MyPrize(int[] rankArr) {
        this.rankArr = rankArr;
        calculateProfitAmount(rankArr);
    }

    private long [] fixedPrizeMoneyByRanking = {
            0,
            RankInfo.FIRST.getReward(),
            RankInfo.SECOND.getReward(),
            RankInfo.THIRD.getReward(),
            RankInfo.FOURTH.getReward(),
            RankInfo.FIFTH.getReward()
    };

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
