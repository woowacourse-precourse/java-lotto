package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ExceptionErrorType;

import java.math.BigInteger;

public class InputView {
    private static final OutputView outputView = new OutputView();

    public BigInteger insertMoney() {
        outputView.announceInsertMoney();

        String input = Console.readLine();
        validateCastPositiveBigInteger(input);
        validateMinMoney(input);
        validateMultipleOf1000(input);
        return new BigInteger(input);
    }

    private void validateCastPositiveBigInteger(String input) {
        try {
            BigInteger target = new BigInteger(input);
            checkPositiveBigInteger(target);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_POSITIVE_NUMBER.getDescription()
            );
        }
    }

    private void checkPositiveBigInteger(BigInteger input) {
        if (input.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateMinMoney(String input) {
        if (input.length() < 3) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER_1000_OR_MORE.getDescription()
            );
        }
    }

    private static void validateMultipleOf1000(String input) {
        int length = input.length();
        String hundreds = input.substring(length - 3, length);
        if (!hundreds.equals("000")) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER_MULTIPLE_OF_1000.getDescription()
            );
        }
    }

}
