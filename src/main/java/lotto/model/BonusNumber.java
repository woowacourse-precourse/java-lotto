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
        /*verifyDuplicateNumber(number);*/
        return number;
    }

  /*  private static void verifyDuplicateNumber(int number) {
        if (Lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }*/

    private static int formatInput(String input) {
        return Integer.parseInt(removeSpace(input));
    }
}
