package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;

public class InputBonusNumber {
    public static BonusNumber input() {
        String input = Console.readLine();
        validateInteger(input);
        return new BonusNumber(Integer.parseInt(input));
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
    }
}
