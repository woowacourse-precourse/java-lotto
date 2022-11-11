package utils;

import camp.nextstep.edu.missionutils.Console;
import system.process.exception.IllegalArgument;

public class Input {

    public static String input() throws IllegalArgumentException {

        try {
            String textInput = Console.readLine();

            if (!IsCollection.isDigitOrCommaText(textInput)) {
                IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_OR_COMMA_TEXT.getMessage());
            }

            return textInput;
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return "NULL";
        }

    }

    public static String inputAmountPaid() {
        printInputAmountPaidText();
        String amountPaidInput = Input.input();

        try {
            if (IsCollection.isContainText(amountPaidInput, ",")) {
                IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_TEXT.getMessage());
            }
            return amountPaidInput;
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return "NULL";
        }
    }

    public static void printInputAmountPaidText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

}
