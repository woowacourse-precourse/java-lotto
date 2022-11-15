package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int LOWER_LIMIT_OF_LOTTO_NUM = 1;
    private static final int UPPER_LIMIT_OF_LOTTO_NUM = 45;
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 1에서 45 사이의 숫자를 입력해야 합니다.";
    private static final String ALREADY_EXISTENT_NUMBER = "[ERROR] 당첨번호에 존재하는 숫자를 입력하면 안됩니다.";

    private final Lotto winninglotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        winninglotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOWER_LIMIT_OF_LOTTO_NUM || bonusNumber > UPPER_LIMIT_OF_LOTTO_NUM) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
        if (winninglotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_EXISTENT_NUMBER);
        }
    }

    public int countMatchNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int countMatchNumbers = 0;

        for (int number : numbers) {
            if (winninglotto.getNumbers().contains(number)) {
                countMatchNumbers++;
            }
        }
        return countMatchNumbers;
    }

    public boolean checkBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
