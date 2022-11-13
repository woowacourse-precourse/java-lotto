package lotto.domain;

import java.util.List;

public class HitLotto {

    private final List<Integer> normalNumbers;
    private final Integer bonusNumber;

    public HitLotto(List<Integer> normalNumbers, Integer bonusNumber) {
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> normalNumbers, Integer bonusNumber) {
        if (normalNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
