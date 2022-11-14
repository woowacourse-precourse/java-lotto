package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = System.lineSeparator() + "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = System.lineSeparator() + "보너스 번호를 입력해 주세요.";
    private static final String INPUT_MONEY_TYPE_ERROR_MESSAGE = "[ERROR] 구입금액은 숫자여야만 합니다.";
    private static final String INPUT_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호는 쉼표를 구분자로 6개의 숫자를 입력해야 합니다.";
    private static final String WINNING_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 숫자여야만 합니다.";
    private static final String BONUS_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야만 합니다.";
    private static final String DELIMITER = ",";

    public static int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();

        return convertToInt(money, INPUT_MONEY_TYPE_ERROR_MESSAGE);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String winningNumbers = Console.readLine();
        checkDelimiter(winningNumbers);
        return Stream.of(winningNumbers.split(DELIMITER))
                .map(c -> convertToInt(c, WINNING_NUMBER_TYPE_ERROR_MESSAGE))
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();

        return convertToInt(bonusNumber, BONUS_NUMBER_TYPE_ERROR_MESSAGE);
    }

    private static void checkDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private static int convertToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
