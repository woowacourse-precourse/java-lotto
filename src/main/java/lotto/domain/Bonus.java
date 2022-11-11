package lotto.domain;

import static lotto.util.Util.removeSpace;
import static lotto.util.Util.verifyRangeOfLottoNumber;


public class Bonus {
    private static int bonusNumber;

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

    public int get() {
        return bonusNumber;
    }
}
