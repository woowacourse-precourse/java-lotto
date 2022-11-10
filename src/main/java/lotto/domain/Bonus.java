package lotto.domain;

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
            throw new IllegalArgumentException();
        }
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkNumber(List<Integer> userLottoNumbers) {
        if (userLottoNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
