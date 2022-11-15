package domain.RankInfo;

import domain.Bonus.Bonus;
import domain.Lotto.Lotto;
import domain.Money.Money;
import domain.UserLotto.UserLotto;

import java.util.List;

public class RankInfoService {
    private final static int CHECK_COUNT = 5;
    private final static Double PERCENTAGE = 100.0;

    public RankInfo createRankInfo() {
        return new RankInfo();
    }

    public RankInfo putRankInfo(RankInfo rankInfo, Lotto lotto, UserLotto userLotto, Bonus bonus) {
        for (int index = 0; index < userLotto.getUserLottoSize(); index++) {
            compare(rankInfo, lotto, userLotto.getOneOfUserLotto(index), bonus);
        }
        return rankInfo;
    }

    public double calcYield(RankInfo rankInfo, Money money) {
        double profit = 0.0;

        for (Rank rank : Rank.values()) {
            if (rankInfo.getMatchNumber(rank) != 0)
                profit += rank.getReward() * rankInfo.getMatchNumber(rank);
        }
        return profit / money.getMoney() * PERCENTAGE;
    }

    public void compare(RankInfo rankInfo, Lotto lotto, List<Integer> userLottoNumbers, Bonus bonus) {
        int count = 0;

        for (int index = 0; index < lotto.getLottoSize(); index++) {
            if (userLottoNumbers.contains(lotto.getLottoNumber(index))) count += 1;
        }
        if (count != CHECK_COUNT)
            updateMatchNumber(rankInfo, userLottoNumbers, bonus, count);
        if (count == CHECK_COUNT)
            updateMatchNumberWithCondition(rankInfo, userLottoNumbers, bonus, count);
    }

    public void updateMatchNumber(RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus, int count) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == count && !isSecond(count, userLottoNumbers, bonus))
                rankInfo.countUp(rank);
        }
    }

    public void updateMatchNumberWithCondition(RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus, int count) {
        if (isSecond(count, userLottoNumbers, bonus))
            rankInfo.countUp(Rank.SECOND);
        if (!isSecond(count, userLottoNumbers, bonus))
            rankInfo.countUp(Rank.THIRD);
    }

    public boolean isSecond(int count, List<Integer> userLottoNumbers, Bonus bonus) {
        return (count == CHECK_COUNT && userLottoNumbers.contains(bonus.getBonusNumber()));
    }
}
