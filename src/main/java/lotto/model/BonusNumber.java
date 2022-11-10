package lotto.model;

import static lotto.Util.removeSpace;
import static lotto.Util.verifyRangeOfLottoNumber;


public class BonusNumber {
    private static int bonusNumber;

    public BonusNumber(String input) {
        this.bonusNumber = validateBonusNumber(formatInput(input));
    }

    private static int validateBonusNumber(int number) {
        verifyRangeOfLottoNumber(number);
        if (WinningNumber.winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
        return number;
    }

    private static int formatInput(String input) {
        return Integer.parseInt(removeSpace(input));
    }
}
