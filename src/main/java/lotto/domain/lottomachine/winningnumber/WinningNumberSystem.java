package lotto.domain.lottomachine.winningnumber;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberSystem {
    public static final String REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT = "\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}";
    public static final String REGULAR_EXPRESSION_FOR_BONUS_NUMBER_INPUT = "\\d";

    public WinningNumbers receiveWinningNumber() {
        String userInput = readUserInput(REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT);
        List<WinningNumber> numbers = createWinningNumberList(userInput);
        return new WinningNumbers(numbers);
    }

    private List<WinningNumber> createWinningNumberList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(WinningNumber::new)
                .collect(Collectors.toList());
    }

    private String readUserInput(String regularExpression) {
        String userInput = Console.readLine();
        validateUserInput(userInput, regularExpression);
        return userInput;
    }

    private void validateUserInput(String line, String regularExpression) {
        if (!line.matches(regularExpression)) {
            throw new IllegalArgumentException("[ERROR] 여섯 개의 숫자를 \",\"로 구분해서 입력해야 합니다.");
        }
    }
}
