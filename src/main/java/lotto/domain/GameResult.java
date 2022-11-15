package lotto.domain;

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
        }
        return 5;
    }
}
