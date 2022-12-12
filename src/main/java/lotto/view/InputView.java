package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String VALUE_IS_NON_NUMERIC_MESSAGE = "입력값은 정수여야 합니다.";
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public static int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        return convertInteger(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(READ_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        String[] splitNumbers = input.split(SEPARATOR);
        List<Integer> winningNumbers = Arrays.stream(splitNumbers)
                .map(InputView::convertInteger)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winningNumbers);
    }

    public static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return convertInteger(input);
    }

    private static int convertInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(VALUE_IS_NON_NUMERIC_MESSAGE);
        }
    }
}
