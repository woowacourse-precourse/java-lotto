package lotto.domain;

import static lotto.view.BonusInput.bonusInput;

import java.util.List;

public class BonusNumber {
    public static boolean bonus;
    private static int bonusNumber;

    public static void getBonusResult(List<List<Integer>> lottos) {
        bonusNumber = bonusToInt(bonusInput);
        bonus = false;
        for (List<Integer> check : lottos) {
            if (check.contains(bonusNumber)) {
                bonus = true;
                break;
            }
        }
    }

    private static int bonusToInt(String bonusInput) {
        bonusNumber = Integer.parseInt(bonusInput);
        return bonusNumber;
    }
}
