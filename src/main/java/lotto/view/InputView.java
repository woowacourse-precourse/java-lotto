package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ValidationErrorMessage;
import lotto.view.constant.InputGuidePhrase;

public class InputView {
    static final String EMPTY_VALUE_ERROR_MESSAGE = ValidationErrorMessage.EMPTY_VALUE.getErrorMessage();
    static final String NOT_NUMBER_ERROR_MESSAGE = ValidationErrorMessage.NOT_NUMBER.getErrorMessage();

    public static int takeMoneyInput() {
        printPurchaseMoneyRequest();
        String input = Console.readLine().trim();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void printPurchaseMoneyRequest() {
        System.out.println(InputGuidePhrase.PURCHASE_MONEY_REQUEST.getText());
    }

    private static void validate (String input) {
        if (Validator.isEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }

        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
