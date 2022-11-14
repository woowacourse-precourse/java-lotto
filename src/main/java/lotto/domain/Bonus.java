package lotto.domain;

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
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
