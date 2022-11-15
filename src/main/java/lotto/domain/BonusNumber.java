package lotto.domain;

import java.util.List;

import static lotto.utils.ExceptionMessage.DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER;
import static lotto.utils.Validation.*;

public class BonusNumber {

    private final int number;

    public BonusNumber(String bonusNumber, WinningLotto winningLotto) {
        this.number = validate(bonusNumber, winningLotto);
    }

    public int getNumber() {
        return number;
    }

    public int validate(String number, WinningLotto winningLotto) {
        validateNull(number);

        int bonusNumber = validateNumber(number);
        validateSingleNumberRange(bonusNumber);

        validateDuplication(winningLotto.getNumbers(), bonusNumber);

        return bonusNumber;
    }


    private void validateDuplication(List<Integer> winningLotto, int number) {
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER.getMessage());
        }
    }

    public static void checkWinningResult(List<Lotto> lottos, WinningLotto winningLotto, BonusNumber bonusNum) {
        for (Lotto lotto : lottos) {
            compareLotto(
                    lotto.getNumbers(),
                    winningLotto.getNumbers(),
                    bonusNum.getNumber());
        }
    }

    public static void compareLotto(List<Integer> lotto, List<Integer> winningNums , int bonusNum) {
        int count = 0;
        boolean checkBonusNum = lotto.contains(bonusNum);

        for (int num : winningNums) {
            if (lotto.contains(num)) {
                count++;
            }
        }

        ResultMessage.increaseCountResult(count, checkBonusNum);
    }
}
