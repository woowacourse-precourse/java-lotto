package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumberInput) {
        if (bonusNumberInput < MIN_NUMBER || bonusNumberInput > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_INPUT_RANGE_ERROR_MESSAGE);
        }
        if (super.isContainNumber(bonusNumberInput)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
