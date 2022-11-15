package lotto.domain;

import java.util.List;

import static constants.Constants.*;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        checkRange(bonusNumber);
        checkBonsDuplicate(lottoNumbers, bonusNumber);
    }

    private void checkBonsDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
        }
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < LOTTO_RANGE_START || LOTTO_RANGE_END < bonusNumber) {
            throw new IllegalArgumentException(ANSWER_RANGE_ERROR);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return super.getNumbers().toString() + " " + bonusNumber;
    }
}
