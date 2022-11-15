package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Input {
    private static final String INVALID_MONEY = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String PARSE_ERROR = "[ERROR] 당첨 번호는 , 기준으로 구분되어야 합니다.";
    private static final String TO_INT_ERROR = "[ERROR] 당첨 번호는 숫자로 구성되어야 합니다.";
    private static final String INVALID_NUMBER = "[ERROR] 보너스 번호는 숫자여야 합니다.";

    private Input() {}

    public static int readMoney() {
        String input = Console.readLine();
        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        try {
            int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(numbers).boxed().collect(Collectors.toList());
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(PARSE_ERROR);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(TO_INT_ERROR);
        }
    }

    public static int readBonusNumber() {
        String input = Console.readLine();
        if (!Validator.isNumber(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
        return Integer.parseInt(input);
    }
}
