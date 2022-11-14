package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;
import java.util.List;
import java.util.Set;

public class WinningBalls {

    private final List<Integer> winningBalls;

    public WinningBalls(List<Integer> winningBalls) {
        validate(winningBalls);
        this.winningBalls = winningBalls;
    }

    public void validate(List<Integer> generalWinNumbers) {
        if (generalWinNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_SIX_DIGIT);
        }

        if (isWithinRange(generalWinNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.WITHIN_RANGE);
        }

        if (Set.copyOf(generalWinNumbers).size() != generalWinNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS);
        }
    }

    public boolean contains(int number) {
        return winningBalls.stream()
                .anyMatch(ball -> ball == number);
    }

    public boolean containsBonusNumber(BonusBall bonusBall) {
        return winningBalls.stream()
                .anyMatch(i -> bonusBall.isSame(i));
    }

    private boolean isWithinRange(List<Integer> winningBalls) {
        return winningBalls.stream()
                .anyMatch(number -> !(number >= LottoGame.LOTTO_MIN_RANGE && number <= LottoGame.LOTTO_MAX_RANGE));
    }

}
