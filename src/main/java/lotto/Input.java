package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String DELIMITER = ",";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요.";
    private static final String SEPARATOR_ERROR = "[ERROR] 구분자 '" + DELIMITER + "' 를 입력해 주세요.";

    public static int getNumber() {
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    public static List<Integer> winningNumber() {
        String input = Console.readLine();
        checkContainDelimiter(input);
        return Stream.of(input.split(DELIMITER))
                .map(Input::convertToInt)
                .collect(Collectors.toList());
    }

    private static void checkContainDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(SEPARATOR_ERROR);
        }
    }
}
