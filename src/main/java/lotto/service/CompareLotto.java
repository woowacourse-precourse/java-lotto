package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

public class CompareLotto {

    public static void compare(List<Rank> ranks, List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int countMatchingNumber = lotto.getCountMatchingNumber(winningNumbers);
            boolean hasBonus = lotto.hasNumber(bonusNumber);
            compareMatchingNumber(ranks, countMatchingNumber, hasBonus);
        }
    }

    private static void compareMatchingNumber(List<Rank> ranks, int matchingNumber, boolean bonus) {
        for (Rank rank : ranks) {
            if(rank.isMatchMatchingNumber(matchingNumber) && containBonus(rank, bonus)) {
                rank.addCount();
            }
        }
    }

    private static boolean containBonus(Rank rank, boolean bonus) {
        if((rank.containBonus() && bonus) || !rank.containBonus()) return true;
        return false;
    }
}
