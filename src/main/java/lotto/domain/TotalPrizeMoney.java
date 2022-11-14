package lotto.domain;

import java.util.List;
import lotto.constants.Rank;

public class TotalPrizeMoney {
    private static final int SECOND_WINNING_INDEX = 2;
    private static final int THIRD_WINNING_INDEX = 3;
    private static final int CHECK_VALUE = 1;

    public int totalCalculation(List<Integer> sameNumberCount, List<Integer> winningRanking) {
        int result = 0;
        for (int correctNumber : sameNumberCount) {
            result = getResult(winningRanking, result, correctNumber);
        }
        return result;
    }

    private int getResult(List<Integer> winningRanking, int result, int correctNumber) {
        if (correctNumber == Rank.FIFTH.getMatch()) {
            result += Rank.FIFTH.getMoney();
        }

        if (correctNumber == Rank.FOURTH.getMatch()) {
            result += Rank.FOURTH.getMoney();
        }

        if (correctNumber == Rank.FIRST.getMatch()) {
            result += Rank.FIRST.getMoney();
        }
        result = getCorrectFivePrize(winningRanking, result, correctNumber);
        return result;
    }

    private int getCorrectFivePrize(List<Integer> winningRanking, int result, int correctNumber) {
        if (correctNumber == Rank.THIRD.getMatch()
                && winningRanking.get(SECOND_WINNING_INDEX) == CHECK_VALUE) {

            result += Rank.THIRD.getMoney();
        }

        if (correctNumber == Rank.SECOND.getMatch()
                && winningRanking.get(THIRD_WINNING_INDEX) == CHECK_VALUE) {

            result += Rank.SECOND.getMoney();
        }
        return result;
    }
}
