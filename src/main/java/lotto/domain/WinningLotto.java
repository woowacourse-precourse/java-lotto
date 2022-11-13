package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumberDuplicated(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER);
        }
    }

    public int match(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return countMatchNumbers(lottoNumbers);
    }

    private int countMatchNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> getNumbers().contains(number))
                .count();
    }

    public boolean isMatchedBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
