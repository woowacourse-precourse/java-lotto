package lotto.model;

import static lotto.util.ErrorMessage.ERROR_BONUS_DUPLICATES;
import static lotto.util.Formatter.removeSpace;
import static lotto.util.Formatter.verifyRangeOfLottoNumber;

import java.util.List;


public class Bonus {
    private int bonusNumber;

    public Bonus(String input) {
        this.bonusNumber = validateBonusNumber(formatInput(input));
    }

    private static int validateBonusNumber(int number) {
        verifyRangeOfLottoNumber(number);
        return number;
    }

    private static int formatInput(String input) {
        return Integer.parseInt(removeSpace(input));
    }

    public static void validateDuplicates(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATES);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
