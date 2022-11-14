package lotto;

import java.util.List;

import static lotto.LottoErrorMessage.*;
import static lotto.LottoConstant.*;
import static lotto.LottoSeller.printMessage;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countWinningNumber(Lotto userLotto) {
        int count = 0;
        List<Integer> userNumbers = userLotto.getNumbers();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            int userNumber = userNumbers.get(i);

            if (winningLotto.hasNumber(userNumber)) {
                count++;
            }
        }

        if (count == WINNING_FIVE_AND_BONUS_NUM && !hasNumberInBonus(userLotto))
            count++;

        return count;
    }

    public boolean hasNumberInBonus(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            printMessage(DUPLICATE_NUM_ERROR_MSG);
            throw new IllegalArgumentException();
        }

        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM) {
            printMessage(LOTTO_RANGE_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }
}
