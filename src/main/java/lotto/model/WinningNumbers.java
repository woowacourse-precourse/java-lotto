package lotto.model;

import lotto.utils.Errors;
import lotto.utils.Rules;

import java.util.List;

public class WinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers() {}

    public void newWinningNumbers(List<Integer> newWinningNumbers) throws IllegalArgumentException {
        this.winningNumbers = new Lotto(newWinningNumbers);
    }

    public void newBonusNumber(int newBonusNumber) throws IllegalArgumentException {
        validateNumberRange(newBonusNumber);
        validateDuplicateBonusNumber(newBonusNumber);
        this.bonusNumber = newBonusNumber;
    }

    private void validateNumberRange(int number) throws IllegalArgumentException {
        if ((number < Rules.LOTTO_MIN_NUMBER) || (number > Rules.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(Errors.ERROR_LOTTO_NUMBER_RANGE.getValue());
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if(winningNumbers.containNumber(bonusNumber)) {
            throw new IllegalArgumentException(Errors.ERROR_LOTTO_BONUS_NUMBER_DUPLICATE.getValue());
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
        for (int lottoIndex = 0; lottoIndex < Rules.LOTTO_SIZE; lottoIndex++) {
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
        int score = includeNumberCount * Rules.SCORE_PER_LOTTO_NUMBER;
        if ((includeNumberCount == Rules.SECOND_CLASS_COUNT) && includeBonusNumber) {
            score = score + Rules.SCORE_BONUS_NUMBER;
        }
        return score;
    }
}
