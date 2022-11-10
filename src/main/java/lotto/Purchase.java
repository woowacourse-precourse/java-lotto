package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {

    public static void lotto() {
        String userInput = Console.readLine();

        int numberOfLotto = getNumberOfLotto(userInput);
    }

    private static int getNumberOfLotto(String userInput) {
        if (!Validation.existOnlyNumber(userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.CANNOT_CONVERT_NUMBER);
        }

        int amount = Integer.parseInt(userInput);
        if (!Validation.isValidRange(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.LOTTO_OUT_OF_RANGE);
        }
        if (!Validation.isValidUnit(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.INVALID_AMOUNT_UNIT);
        }

        return amount / 1000;
    }
}
