package lotto.domain.lottoData;

import java.util.List;

public class WinnerLotto {

    private final List<Integer> normalNumbers;
    private final Integer bonusNumber;

    public WinnerLotto(List<Integer> lottoNumbers) {
        validateBonusNumber(lottoNumbers.subList(0, 6), lottoNumbers.get(6));
        this.normalNumbers = lottoNumbers.subList(0, 6);
        this.bonusNumber = lottoNumbers.get(6);
    }

    public List<Integer> getNormalNumbers() {

        return normalNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(List<Integer> normalNumbers, Integer bonusNumber) {
        if (normalNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
