package lotto.domain.manager;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AwardManager {
    public static List<Award> makeAwards(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        List<Award> awards = new ArrayList<>();
        for (int i = 0; i < userLotto.size(); i++) {
            Lotto eachLotto = userLotto.getLottoAt(i);
            int score = winningLotto.grade(eachLotto);
            awards.add(Award.getByOrdinal(score));
        }
        applyBonusNumber(userLotto, bonusNumber, awards);
        return awards;
    }

    private static void applyBonusNumber(UserLotto userLotto, BonusNumber bonusNumber, List<Award> awards) {
        Stream.iterate(0, i -> i + 1)
                .limit(awards.size())
                .filter(i -> awards.get(i).equals(Award.FIVE))
                .filter(i -> userLotto.getLottoAt(i).contains(bonusNumber.getBonusNumber()))
                .forEach(i -> awards.set(i, Award.FIVE_BONUS));
    }
}
