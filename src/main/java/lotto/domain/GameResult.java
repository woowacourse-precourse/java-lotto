package lotto.domain;

import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResult {
    public static Integer getMatchingCount(List<Integer> randomLotto, List<Integer> inputLotto) {
        int count = 0;

        for (int index = 0; index < inputLotto.size(); index++) {
            if (isContained(randomLotto, inputLotto.get(index))) {
                count++;
            }
        }

        return count;
    }

    public static boolean isContained(List<Integer> lotto, int number) {
        return lotto.contains(number);
    }

    public static Integer getGameRank(List<Integer> randomLotto, List<Integer> inputLotto, int bonusNumber) {
        int count = getMatchingCount(randomLotto, inputLotto);

        if (count == 6) {
            return 1;
        } else if (count == 5) {
            if (isContained(randomLotto, bonusNumber)) return 2;
            return 3;
        } else if (count == 4) {
            return 4;
        } else if (count == 3) {
            return 5;
        }
        return 0;
    }

    public static List<Integer> getGameRankCount(List<Integer> ranks) {
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < Constant.RANK_COUNT; i++) {
            counts.add(0);
        }

        for (int rank : ranks) {
            if (rank == 0) continue;
            counts.set((rank - 1), counts.get(rank - 1) + 1);
        }

        return counts;
    }

    public static Integer calculateSum(List<Integer> counts) {
        List<Integer> amount = new ArrayList<>(Arrays.asList(Constant.WINNING_FIRST_AMOUNT, Constant.WINNING_SECOND_AMOUNT, Constant.WINNING_THIRD_AMOUNT, Constant.WINNING_FOURTH_AMOUNT, Constant.WINNING_FIFTH_AMOUNT));
        int result = 0;

        for (int i = 0; i < counts.size(); i++) {
            result += amount.get(i) * counts.get(i);
        }
        return result;
    }

    public static Double calculateRateOfReturn(int purchaseAmount, int sum) {
        return sum * 100.0 / purchaseAmount;
    }
}
