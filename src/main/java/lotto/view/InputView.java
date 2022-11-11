package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.validator.NumberValidator.validateNonNumeric;
import static lotto.validator.NumberValidator.validateUnit;

public class InputView {
    public static int inputLottoPurchaseAmount() {
        OutputView.printLottoPurchaseAmount();
        String input = Console.readLine();

        validateNonNumeric(input);
        validateUnit(input);
        return Integer.parseInt(input);
    }
}
