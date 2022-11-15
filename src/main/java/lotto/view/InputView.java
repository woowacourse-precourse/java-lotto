package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String readLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static int money() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String input = readLine();

        Validate.isNumber(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumber() {
        System.out.println(NUMBER_INPUT_MESSAGE);
        List<String> input = Arrays.asList(readLine().split(","));

        Validate.isNumbers(input);
        List<Integer> winningNumber = stringToInteger(input);

        Validate.rangeNumbers(winningNumber, 1, 45);
        Validate.length(winningNumber, 6);
        Validate.duplication(winningNumber);

        return winningNumber;
    }

    public static int bonusNumber(List<Integer> winningNumber) {
        System.out.println(BONUS_INPUT_MESSAGE);
        String input = readLine();

        Validate.isNumber(input);
        int bonusNumber = Integer.parseInt(input);

        Validate.rangeNumber(bonusNumber, 1, 45);
        Validate.bonusInWinningNumbers(winningNumber, bonusNumber);

        return bonusNumber;
    }

    public static List<Integer> stringToInteger(List<String> numbers) {
        return numbers.stream()
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
    }
}
