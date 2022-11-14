package service;

import domain.*;

import java.util.List;

public class RankInfoService {
    private final static int CHECK_COUNT = 5;
    private final static Double PERCENTAGE = 100.0;

    public RankInfo createRankInfo() {
        return new RankInfo();
    }

    public RankInfo putRankInfo(RankInfo rankInfo, Lotto lotto, UserLotto userLotto, Bonus bonus) {
        for (int index = 0; index < userLotto.getUserLottoSize(); index++) {
            updateCount(rankInfo, lotto, userLotto.getUserLottoNumbers(index), bonus);
        }
        return rankInfo;
    }

    public double calcYield(RankInfo rankInfo, Money money) {
        double profit = 0.0;

        for (Rank rank : Rank.values()) {
            if (rankInfo.getMatchNumber(rank) != 0)
                profit += rank.getReward();
        }
        return profit / money.getMoney() * PERCENTAGE;
    }

    public void updateCount(RankInfo rankInfo, Lotto lotto, List<Integer> userLottoNumbers, Bonus bonus) {
        int count = 0;

        for (int index = 0; index < lotto.getLottoSize(); index++) {
            if (userLottoNumbers.contains(lotto.getLottoNumber(index))) count += 1;
        }
        if (count == CHECK_COUNT)
            countUpWithCheck(rankInfo, userLottoNumbers, bonus, count);
        if (count != CHECK_COUNT)
            countUpDefault(rankInfo, userLottoNumbers, bonus, count);
    }

    public void countUpDefault(RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus, int count) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == count && !isSecond(count, userLottoNumbers, bonus))
                rankInfo.countUp(rank);
        }
    }

    public void countUpWithCheck(RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus, int count) {
        if (isSecond(count, userLottoNumbers, bonus))
            rankInfo.countUp(Rank.SECOND);
        if (!isSecond(count, userLottoNumbers, bonus))
            rankInfo.countUp(Rank.THIRD);
    }

    public boolean isSecond(int count, List<Integer> userLottoNumbers, Bonus bonus) {
        return (count == CHECK_COUNT && userLottoNumbers.contains(bonus.getBonusNumber()));
    }
}
