package lotto.domain;

import java.util.List;

public class Bonus {
    private final int bonusNumber;
    private final List<Integer> lottoNumbers;

    public Bonus(List<Integer> lottoNumbers, int bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkBonus(List<Integer> userNumbers) {
        if (userNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
