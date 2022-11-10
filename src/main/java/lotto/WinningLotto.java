package lotto;

import java.util.List;

import static lotto.LottoErrorMessage.*;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            System.out.println(DUPLICATE_NUM_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }
}
