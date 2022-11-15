package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private static final String BONUS_IS_NOT_UNIQUE_MESSAGE ="[ERROR] 보너스 번호는 당첨 번호와 중복이 존재할 수 없습니다.";

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateLottoNumberRange(bonusNumber);
        validateWinningLottoIsUnique(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningLottoIsUnique(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_IS_NOT_UNIQUE_MESSAGE);
        }
    }
}