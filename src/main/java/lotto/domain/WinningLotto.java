package lotto.domain;

import java.util.List;

import static lotto.domain.LottoGenerator.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoGenerator.MINIMUM_LOTTO_NUMBER;
import static lotto.support.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.support.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winningLotto = lotto;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateBonusNumberDuplicated(numbers, bonusNumber);
    }

    public static WinningLotto from(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    private void validateBonusNumberDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR);
        }
    }

    public int match(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return countMatchNumbers(lottoNumbers);
    }

    private int countMatchNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    public boolean isMatchedBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
