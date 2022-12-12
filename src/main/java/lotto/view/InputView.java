package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String VALUE_IS_NON_NUMERIC_MESSAGE = "입력값은 정수여야 합니다.";
    private static final String SEPARATOR = ",";

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertInteger(input);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();
        String[] splitNumbers = input.split(SEPARATOR);
        List<Integer> winningNumbers = Arrays.stream(splitNumbers)
                .map(InputView::convertInteger)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    private static int convertInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(VALUE_IS_NON_NUMERIC_MESSAGE);
        }
    }
}
