package lotto.domain;

import java.util.List;
import lotto.constants.Rank;

public class TotalPrizeMoney {

    public int calculation(List<Integer> numbers, List<Integer> countCheck) {
        int result = 0;
        for (int number : numbers) {
            if (number == Rank.FIFTH.getMatch()) {
                result += Rank.FIFTH.getMoney();
            }

            if (number == Rank.FOURTH.getMatch()) {
                result += Rank.FOURTH.getMoney();
            }

            if (number == Rank.THIRD.getMatch()) {
                if (countCheck.get(2) == 1) {
                    result += Rank.THIRD.getMoney();
                }
            }

            if (number == Rank.SECOND.getMatch()) {
                if (countCheck.get(3) == 1) {
                    result += Rank.SECOND.getMoney();
                }
            }

            if (number == Rank.FIRST.getMatch()) {
                result += Rank.FIRST.getMoney();
            }
        }

        return result;
    }

}
