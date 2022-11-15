package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Input {
    private Input() {}

    public static int readMoney() {
        String input = Console.readLine();
        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        try {
            int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(numbers).boxed().collect(Collectors.toList());
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(ErrorMessage.PARSE_ERROR.getMessage());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.TO_INT_ERROR.getMessage());
        }
    }

    public static int readBonusNumber() {
        String input = Console.readLine();
        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
        return Integer.parseInt(input);
    }
}
