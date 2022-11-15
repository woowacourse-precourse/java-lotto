package lotto.util;

import lotto.domain.constant.Message;
import lotto.domain.constant.Number;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandler {

    public static void checkValidationMoney(String input) throws IllegalArgumentException {
        try {
            int inputNumber = Integer.parseInt(input);
            checkThousandUnit(inputNumber);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkThousandUnit(int input) throws IllegalArgumentException {
        if ((input % Number.THOUSAND) != Number.ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidationWinningNumber(String input) throws IllegalArgumentException {
        String[] tokens = applyTrim(input);
        try {
            isSixNumbers(tokens);
            isOnlyCommaAndNumber(tokens);
            isAllDifferentNumbers(tokens);
            isValidationRange(tokens);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] applyTrim(String input) {
        String[] tokens = input.split(Message.COMMA.getMessage());
        for (int index = 0; index < tokens.length; index++) {
            tokens[index] = tokens[index].trim();
        }
        return tokens;
    }

    private static void isSixNumbers(String[] tokens) throws IllegalArgumentException {
        if (tokens.length != Number.SIX) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOnlyCommaAndNumber(String[] tokens) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(Message.NOT_NUMBER_REGEX.getMessage());
        for (String number : tokens) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isAllDifferentNumbers(String[] tokens) throws IllegalArgumentException {
        List<String> container = new ArrayList<>();
        for (String number : tokens) {
            if (container.contains(number)) {
                throw new IllegalArgumentException();
            }
            container.add(number);
        }
    }

    private static void isValidationRange(String[] tokens) throws IllegalArgumentException {
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (isValidate(number)) {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidate(int number) {
        return Number.ONE <= number && number <= Number.FORTY_FIVE;
    }

    public static void checkValidationBonusNumber(String input, List<Integer> winningNumbers) throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(input);
        isValidationRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidationRange(int bonusNumber) throws IllegalArgumentException {
        if (Number.ONE <= bonusNumber && bonusNumber <= Number.FORTY_FIVE) {
            return;
        }
        throw new IllegalArgumentException();
    }
}