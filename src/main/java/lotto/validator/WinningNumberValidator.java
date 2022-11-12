package lotto.validator;

import java.util.List;

public class WinningNumberValidator {
    private final int MINIMUM_LOTTO_NUMBER = 1;
    private final int MAXIMUM_LOTTO_NUMBER = 45;
    private final int RIGHT_LOTTO_SIZE = 6;

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumberRange(winningNumbers);
        validateNumberSize(winningNumbers);
        validateDuplicateNumber(winningNumbers);
    }

    public void validateBonusNumber(int bonusNumber) {
        if (!validRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(List<Integer> lotto) {
        lotto.forEach(number -> {
            if (!validRange(number)) {
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean validRange(Integer number) {
        return (MINIMUM_LOTTO_NUMBER <= number) && (number <= MAXIMUM_LOTTO_NUMBER);
    }

    public void validateDuplicateNumber(List<Integer> lotto) {
        if (lotto.size() != lotto.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 당첨 번호가 있습니다.");
        }
    }

    public void validateNumberSize(List<Integer> lotto) {
        if (lotto.size() != RIGHT_LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호 6개를 입력해야합니다.");
        }
    }

    public void validateWinningNumbersContainBonusNumber(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복된 보너스 번호를 입력했습니다.");
        }
    }
}
