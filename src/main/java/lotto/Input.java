package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String SEPARATOR = ",";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요.";
    private static final String SEPARATOR_ERROR = "[ERROR] 구분자 '" + SEPARATOR + "' 를 입력해 주세요.";

    public static int purchaseAmount() {
        return changeNumber(input());
    }

    public static List<Integer> winningNumber() {
        String input = input();
        checkContainSeparator(input);
        return Stream.of(input.split(SEPARATOR))
                .map(Input::changeNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public static int bonus() {
        String input = input();
        return changeNumber(input);
    }

    private static int changeNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private static void checkContainSeparator(String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATOR_ERROR);
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
