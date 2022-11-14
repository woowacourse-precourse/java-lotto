package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.validation.InputNumbersValidation;

public class InputView {
    public static String buyLotto() {
        System.out.println(GameMessage.BUY);
        return Console.readLine();
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(GameMessage.INPUT_NUMBERS);
        String userNumbers = Console.readLine();
        InputNumbersValidation .validate(userNumbers);
        return InputUtil.convertUserInputToNumbers(userNumbers);
    }

    public static String inputBonusNumber() {
        System.out.println(GameMessage.INPUT_BONUS);
        return Console.readLine();
    }
}
