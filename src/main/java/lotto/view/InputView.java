package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ExceptionErrorType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Integer> inputWinningNumbers() {
        outputView.announceInputWinningNumbers();

        String input = Console.readLine();
        validateCommaSplit(input);
        validateDuplicateNumber(input);
        return convertList(input);
    }
    private List<Integer> convertList(String input) {
        List<Integer> arrayList = new ArrayList<>();

        for (String number :
                input.split(",")) {
            validateCastInteger(number);
            validateRange(number);
            arrayList.add(Integer.parseInt(number));
        }
        return arrayList;
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        outputView.announceInputBonusNumber();

        String input = Console.readLine();
        validateCastInteger(input);
        validateRange(input);
        validateNotContainWinningNumbers(input, winningNumbers);
        return Integer.valueOf(input);
    }

    private void validateCastInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER.getDescription()
            );
        }
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

    private void validateCommaSplit(String input) {
        try {
            input.split(",");
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER_SPLIT_BY_COMMA.getDescription()
            );
        }
    }
    private void validateDuplicateNumber(String input) {
        if (6 != Arrays.stream(input.split(",")).distinct().count()) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NOT_DUPLICATE_NUMBER.getDescription()
            );
        }
    }

    private void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER_BETWEEN_1_45.getDescription()
            );
        }
    }

    private void validateNotContainWinningNumbers(String bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER_NOT_IN_WINNING_NUMBERS.getDescription()
            );
        }
    }

}
