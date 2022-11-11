package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.validator.NumberValidator.*;

public class InputView {
    public static int inputLottoPurchaseAmount() {
        OutputView.printLottoPurchaseAmount();
        String input = Console.readLine();

        validateNonNumeric(input);
        validateUnit(input);
        return Integer.parseInt(input);
    }

    public static String inputLottoNumbers() {
        OutputView.printLottoNumbers();
        String input = Console.readLine();
        return input;
    }

    public static int inputBonusNumber() {
        OutputView.printLottoBonusNumber();
        String input = Console.readLine();

        validateNonNumeric(input);
        validateRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }
}
