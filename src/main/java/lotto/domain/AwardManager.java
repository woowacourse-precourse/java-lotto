package lotto.domain;

import lotto.system.Constant;
import lotto.util.Util;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AwardManager {
        public static void doAwardProcess(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        List<Award> awards = AwardManager.makeAwards(winningLotto, userLotto, bonusNumber);
        float yield = AwardManager.makeYield(awards, userLotto.size());

        OutputView.printReward(awards);
        OutputView.printRate(yield);
    }

    private static List<Award> makeAwards(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        List<Award> awards = makeAward(winningLotto, userLotto);
        applyBonusNumber(userLotto, bonusNumber, awards);
        return awards;
    }

    public static List<Award> makeAward(WinningLotto winningLotto, UserLotto userLotto) {
        List<Award> awards = new ArrayList<>();
        for (int i = 0; i < userLotto.size(); i++) {
            Lotto eachLotto = userLotto.getLottoAt(i);
            int score = winningLotto.grade(eachLotto);
            awards.add(Award.getByOrdinal(score));
        }
        return awards;
    }

    private static void applyBonusNumber(UserLotto userLotto, BonusNumber bonusNumber, List<Award> awards) {
        Stream.iterate(0, i -> i + 1)
                .limit(awards.size())
                .filter(i -> awards.get(i).equals(Award.FIVE))
                .filter(i -> userLotto.getLottoAt(i).contains(bonusNumber.getBonusNumber()))
                .forEach(i -> awards.set(i, Award.FIVE_BONUS));
    }

    private static float makeYield(List<Award> prize, int userLottoSize) {
        float beforeMoney = userLottoSize * Constant.MONEY_UNIT;
        float totalMoney = beforeMoney;
        for (Award award : prize) {
            totalMoney += award.getReward();
        }
        return Util.calculateYield(totalMoney, beforeMoney);
    }
}
