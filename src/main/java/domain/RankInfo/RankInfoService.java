package domain.RankInfo;

import domain.Bonus.Bonus;
import domain.Lotto.Lotto;
import domain.Money.Money;
import domain.UserLotto.UserLotto;

import java.util.List;

public class RankInfoService {
    private final static int CHECK_POINT = 5;
    private final static Double PERCENTAGE = 100.0;

    public RankInfo createRankInfo() {
        return new RankInfo();
    }
    public RankInfo putRankInfo(RankInfo rankInfo, Lotto lotto, UserLotto userLotto, Bonus bonus) {
        List<Integer> userLottoNumbers;
        for (int index = 0; index < userLotto.getUserLottoSize(); index++) {
            userLottoNumbers =  userLotto.getOneOfUserLotto(index);
            checkCondition(calcMatchPoint(lotto,userLottoNumbers), rankInfo, userLottoNumbers, bonus);
        }
        return rankInfo;
    }
    public void checkCondition(int matchPoint, RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus) {
        if (matchPoint != CHECK_POINT)
            updateMatchPoint(matchPoint, rankInfo, userLottoNumbers, bonus);
        if (matchPoint == CHECK_POINT)
            updateMatchPointWithCondition(matchPoint, rankInfo, userLottoNumbers, bonus);
    }
    public int  calcMatchPoint(Lotto lotto, List<Integer> userLottoNumbers) {
        int matchPoint = 0;

        for (int index = 0; index < lotto.getLottoSize(); index++) {
            if (userLottoNumbers.contains(lotto.getLottoNumber(index))) matchPoint += 1;
        }
        return matchPoint;
    }
    public void updateMatchPoint(int matchPoint, RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchPoint && !isSecond(matchPoint, userLottoNumbers, bonus))
                rankInfo.countUp(rank);
        }
    }
    public void updateMatchPointWithCondition(int matchPoint, RankInfo rankInfo, List<Integer> userLottoNumbers, Bonus bonus) {
        if (isSecond(matchPoint, userLottoNumbers, bonus))
            rankInfo.countUp(Rank.SECOND);
        if (!isSecond(matchPoint, userLottoNumbers, bonus))
            rankInfo.countUp(Rank.THIRD);
    }
    public boolean isSecond(int matchPoint, List<Integer> userLottoNumbers, Bonus bonus) {
        return (matchPoint == CHECK_POINT && userLottoNumbers.contains(bonus.getBonusNumber()));
    }
    public double calcYield(RankInfo rankInfo, Money money) {
        double profit = 0.0;

        for (Rank rank : Rank.values()) {
            if (rankInfo.getMatchNumber(rank) != 0)
                profit += rank.getReward() * rankInfo.getMatchNumber(rank);
        }
        return profit / money.getMoney() * PERCENTAGE;
    }
}
