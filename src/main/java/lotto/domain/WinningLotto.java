package lotto.domain;

import java.util.List;

import static lotto.domain.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.domain.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicationWithWiningNumbers(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < Lotto.MINIMUM_NUMBER || bonusNumber > Lotto.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicationWithWiningNumbers(int bonusNumber) {
        if (winningLotto.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public Rank compare(Lotto lotto) {
        int count = countSameNumbers(lotto);
        boolean isBonus = lotto.getNumbers().contains(bonusNumber);

        Rank rank = Rank.findRank(count, isBonus);
        return rank;
    }

    private int countSameNumbers(Lotto lotto) {
        long count = winningLotto.getNumbers()
                .stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
        return (int)count;
    }
}
