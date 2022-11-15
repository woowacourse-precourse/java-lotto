package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력은 숫자여야만 합니다.";
    private static final String INPUT_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호는 쉼표를 구분자로 6개의 숫자를 입력해야 합니다.";

    public static int inputNumber() {
        return convertToInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        checkDelimiter(winningNumbers);
        return Stream.of(winningNumbers.split(DELIMITER))
                .map(InputView::convertToInt)
                .collect(Collectors.toList());
    }

    private static void checkDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
        }
    }
}
