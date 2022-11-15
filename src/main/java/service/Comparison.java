package service;

import domain.Lotto;
import domain.Rank;

import java.util.List;

public class Comparison {

    public static void compareLottos(List<Rank> ranks, List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int countMatching = getMatchingCountNumbers(lotto, winningNumbers);
            boolean bonus = hasBonus(lotto, bonusNumber);
            resultRank(ranks, countMatching, bonus);
        }
    }

    public static int getMatchingCountNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int cnt = 0;

        for (Integer number : winningNumbers) {
            if (lotto.getNumbers().contains(number)) cnt++;
        }

        return cnt;
    }

    private static boolean hasBonus(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) return true;
        return false;
    }

    private static void resultRank(List<Rank> ranks, int countMatching, boolean bonus) {
        for (Rank rank : ranks) {
            if ((rank.getMatch() == countMatching) && containBonus(rank, bonus)) {
                rank.addCount();
            }
        }
    }

    private static boolean containBonus(Rank rank, boolean bonus) {
        if ((rank.isBonus() && bonus) || !rank.isBonus()) return true;
        return false;
    }


}
