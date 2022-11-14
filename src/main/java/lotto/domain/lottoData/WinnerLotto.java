package lotto.domain.lottoData;

import java.util.List;

public class WinnerLotto {

    private final List<Integer> normalNumbers;
    private final Integer bonusNumber;

    public WinnerLotto(List<Integer> normalNumbers, Integer bonusNumber) {
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> normalNumbers, Integer bonusNumber) {
        if (normalNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
