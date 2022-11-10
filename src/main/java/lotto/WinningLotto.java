package lotto;

import java.util.List;

public class WinningLotto {
    private static final String DUPLICATE_NUM_ERROR_MSG = "[ERROR] 보너스 번호와 로또 번호가 중복되었습니다.";

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
