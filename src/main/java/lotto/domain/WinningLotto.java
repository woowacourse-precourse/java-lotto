package lotto.domain;

import java.util.List;

import static lotto.support.ErrorMessage.DUPLICATED_NUMBER_ERROR;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumberDuplicated(lotto.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winningLotto = lotto;
    }

    private void validateBonusNumberDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
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

    public static WinningLotto from(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
