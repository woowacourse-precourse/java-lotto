package lotto.domain;

import java.util.List;
import lotto.constants.Rank;

public class TotalPrizeMoney {
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
        if (correctNumber == Rank.THIRD.getMatch() && winningRanking.get(2) == 1) {
            result += Rank.THIRD.getMoney();
        }

        if (correctNumber == Rank.SECOND.getMatch() && winningRanking.get(3) == 1) {
            result += Rank.SECOND.getMoney();
        }
        return result;
    }
}
