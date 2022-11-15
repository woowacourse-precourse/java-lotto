package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Lotto.validateNumberRange;
import static lotto.ErrorMessage.BONUS_NUMBER_IS_DUPLICATED;

public class Bonus {
    public static int BonusNumber;

    public static void askBonusNumber() {
        System.out.println("\n" + Constant.ASK_BONUS_NUMBER);
        String Bonus = Console.readLine();
        BonusNumber = Integer.parseInt(Bonus);
        validateNumberRange(BonusNumber);
        BonusValidate(BonusNumber, Game.JackpotNumbers);
    }

    public static void BonusValidate(int BonusNumber, List<Integer> numbers) {
        if (numbers.contains(BonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED.getMsg());
        }
    }
}
