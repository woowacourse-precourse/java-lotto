package lotto.validator;

import java.util.List;

import static lotto.utils.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.utils.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.utils.LottoConstant.RIGHT_LOTTO_SIZE;

public class WinningNumberValidator {
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
        return (MIN_LOTTO_NUMBER <= number) && (number <= MAX_LOTTO_NUMBER);
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
