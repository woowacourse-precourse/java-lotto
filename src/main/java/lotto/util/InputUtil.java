package lotto.util;

import lotto.domain.enums.Message;
import lotto.domain.enums.Number;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {

    private final String NOT_NUMBER_REGEX = "\\D";
    private final String NOT_NUMBER_AND_COMMA_REGEX = "";
    private final String COMMA = ",";

    Pattern pattern = Pattern.compile(NOT_NUMBER_REGEX);

    public String getUserInput() {
        String input = readLine();
        return input;
    }

    public void checkValidationMoney(String input) {
        int inputNumber = Integer.parseInt(input);

        if (inputNumber % Number.THOUSAND.getValue() != Number.ZERO.getValue()) {
            throw makeIllegalArgumentException(Message.BONUS_NUMBER_INPUT_ERROR.getMessage());
        }
    }

    public void checkValidationBonusNumber(String input, List<Integer> lottoNumbers) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw makeIllegalArgumentException(Message.BONUS_NUMBER_INPUT_ERROR.getMessage());
        }
    }

    public void checkValidationWinningNumber(String input) {
        try {
            isOnlyCommaAndNumber(input);

        } catch (IllegalArgumentException illegalArgumentException) {
            throw makeIllegalArgumentException(Message.WINNING_NUMBER_INPUT_ERROR.getMessage());
        }
    }

    public void isOnlyCommaAndNumber(String input) throws IllegalArgumentException {
        String[] numbers = input.split(COMMA);
        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public IllegalArgumentException makeIllegalArgumentException(String message) {
        return new IllegalArgumentException(message);
    }
}
