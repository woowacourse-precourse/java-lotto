package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String DELIMITER = ",";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요.";
    private static final String SEPARATOR_ERROR = "[ERROR] 구분자 '" + DELIMITER + "' 를 입력해 주세요.";

    /**
     * 구입 금액이나 보너스 번호를 입력받는데에 쓰이는 함수
     */
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

    public static List<Integer> winningTicket() {
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
