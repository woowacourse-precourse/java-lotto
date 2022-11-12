package lotto.domain.lottomachine.winningnumber;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberSystem {
    public static final String REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT = "\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}";
    public static final String REGULAR_EXPRESSION_FOR_BONUS_NUMBER_INPUT = "\\d{1,2}";

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
            throw new IllegalArgumentException("[ERROR] 숫자 입력 형식이 맞지 않습니다.");
        }
    }

    public WinningNumber receiveBonusNumber(WinningNumbers winningNumbers) {
        int number = Integer.parseInt(readUserInput(REGULAR_EXPRESSION_FOR_BONUS_NUMBER_INPUT));
        validateDuplication(number, winningNumbers);
        return new WinningNumber(number);
    }

    private void validateDuplication(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }
}
