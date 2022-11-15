package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String NUMBER_PATTERN = "^[0-9]*$";

    public static int getMoney() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
        String input = Console.readLine();
        return convertToNumber(input);
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(LOTTO_NUMBER_MESSAGE);
        String input = Console.readLine();
        return Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(InputView::convertToNumber)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return convertToNumber(input);
    }

    private static int convertToNumber(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches() || input.isEmpty()) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
