package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private static final int LOTTO_SIZE = 6;
    private static final int SCORE_PER_LOTTO_NUMBER = 2;
    private static final int SCORE_BONUS_NUMBER = 1;
    private static final int SECOND_CLASS_COUNT = 5;

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers() {}

    public void newWinningNumbers(List<Integer> newWinningNumbers) throws IllegalArgumentException {
        winningNumbers = new Lotto(newWinningNumbers);
    }

    public void newBonusNumber(int newBonusNumber) throws IllegalArgumentException {
        validateNumberRange(newBonusNumber);
        bonusNumber = newBonusNumber;
    }

    private void validateNumberRange(int number) throws IllegalArgumentException {
        if ((number < 1) || (number > 45)) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_RANGE.getValue());
        }
    }

    public Rank rankingLotto(Lotto lotto) {
        int includeNumberCount = includeNumberCount(lotto);
        boolean includeBonusNumber = includeBonusNumber(lotto);
        int score = calculateScore(includeNumberCount, includeBonusNumber);
        return Rank.findByScore(score);
    }

    private int includeNumberCount(Lotto lotto) {
        int includeNumberCount = 0;
        int lottoNumber;
        for (int lottoIndex = 0; lottoIndex < LOTTO_SIZE; lottoIndex++) {
            lottoNumber = lotto.findLottoNumber(lottoIndex);
            if (winningNumbers.containNumber(lottoNumber)) {
                includeNumberCount = includeNumberCount + 1;
            }
        }
        return includeNumberCount;
    }

    private boolean includeBonusNumber(Lotto lotto) {
        return lotto.containNumber(bonusNumber);
    }

    private int calculateScore(int includeNumberCount, boolean includeBonusNumber) {
        int score = includeNumberCount * SCORE_PER_LOTTO_NUMBER;
        if ((includeNumberCount == SECOND_CLASS_COUNT) && includeBonusNumber) {
            score = score + SCORE_BONUS_NUMBER;
        }
        return score;
    }
}
