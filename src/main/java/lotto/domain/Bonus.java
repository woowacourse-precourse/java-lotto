package lotto.domain;

import lotto.standard.Bug;

import java.util.List;

public class Bonus {
    private final int number;
    private final List<Integer> lottoNumbers;

    public Bonus(List<Integer> lottoNumbers, int bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.number = bonusNumber;
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Bug.ERROR.getMessage()
                    + Bug.BONUS_NO_CONTAIN_NUMBERS);
        }
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(Bug.ERROR.getMessage()
                    + Bug.BONUS_MUST_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    public boolean checkNumber(List<Integer> userLottoNumbers) {
        if (userLottoNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
