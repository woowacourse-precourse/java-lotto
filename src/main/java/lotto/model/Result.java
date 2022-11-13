package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

public class Result {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    private Result() {
    }

    private Result(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Result of(List<Integer> winningNumbers, int bonusNumber) {
        return new Result(winningNumbers, bonusNumber);
    }

    public Prize compare(Lotto lotto) {
        int winningMatches = checkWithWinningNumbers(lotto);

        int bonusMatches = checkWithBonusNumber(lotto);

        return Prize.judge(winningMatches, bonusMatches);
    }

    private int checkWithBonusNumber(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private int checkWithWinningNumbers(Lotto lotto) {
        return toIntExact(winningNumbers.stream()
                .filter(lotto::contains)
                .count());
    }
}
