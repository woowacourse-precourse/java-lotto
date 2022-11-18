package lotto.view;

import static lotto.constants.ConsoleConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constants.ConsoleConstants.INPUT_PURCHASE_MESSAGE;
import static lotto.constants.ConsoleConstants.INPUT_WINNING_NUMBER_MESSAGE;
import static lotto.constants.RegexConstants.COMMA;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Validator;

public class InputView {

    public static int inputPurchase() {
        notice(INPUT_PURCHASE_MESSAGE);
        String purchase = Console.readLine();
        Validator.validatePurchase(purchase);

        return Integer.parseInt(purchase);
    }

    public static List<Integer> inputWinningNumber() {
        notice(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        Validator.validateWinningNumbers(winningNumber);

        return Arrays.stream(winningNumber.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        notice(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        Validator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private static void notice(String inputMessage) {
        System.out.println(inputMessage);
    }

}
