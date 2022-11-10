package lotto.validator;

//- 주어진 번호들을 `comma(,)`로 구분할 수 없을 때,
//- 중복된 숫자가 있을 경우,
//- 입력 받은 번호의 사이즈가 6이 아닐 때,
//- 1 이상 45 이하의 수가 아닌 이외의 문자나 숫자를 입력할 때,
//- 보너스 번호가 당첨 번호에 포함되어 있을 때,

import java.util.List;

public class WinningNumberValidator {
    private final int MINIMUM_LOTTO_NUMBER = 1;
    private final int MAXIMUM_LOTTO_NUMBER = 45;
    private final int RIGHT_LOTTO_SIZE = 6;

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
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberSize(List<Integer> lotto) {
        if (lotto.size() != RIGHT_LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbersContainBonusNumber(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
