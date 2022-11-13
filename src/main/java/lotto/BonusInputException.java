package lotto;

import java.util.List;

public class BonusInputException {

    public static void bonusTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
    }

    public static void bonusRangeError(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력해야 합니다.");
        }
    }

    public static void bonusDuplicate(List<Integer> winNums, int bonus) {
        if (winNums.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수를 입력하였습니다.");
        }
    }
}
