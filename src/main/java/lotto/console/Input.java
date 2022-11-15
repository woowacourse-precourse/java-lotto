package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validator;

public class Input {

    public static int inputMoney() {
        String money = Console.readLine();
        Validator.validateInputMoney(money);
        return Integer.parseInt(money);
    }

    public static String[] inputLottoNumbers() {
        return Console.readLine().split(",");
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        Validator.isCorrectBonusNumberPattern(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
