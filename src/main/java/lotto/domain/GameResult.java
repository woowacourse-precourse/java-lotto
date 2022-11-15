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

    private static boolean isContained(List<Integer> lotto, int number) {
        return lotto.contains(number);
    }

}
