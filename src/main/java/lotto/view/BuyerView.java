package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BuyerView {
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ERROR_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_NUMBERS = "[ERROR] 숫자,숫자 형식을 맞춰주세요.";
    private static final String REGEX_INT = "^[0-9]+$";

    public static int inputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
        String input = readLine();
        isValidMoneyInput(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputNumbers() {
        System.out.println(MESSAGE_INPUT_NUMBERS);
        String input = readLine();
        isValidNumbers(input);
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void isValidMoneyInput(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }

    private static boolean isDigit(String input) {
        return Pattern.matches(REGEX_INT, input);
    }


    private static void isValidNumbers(String input) {
        if (!Arrays.stream(input.split(",")).allMatch(BuyerView::isDigit)) {
            throw new IllegalArgumentException(ERROR_NUMBERS);
        }
    }
}
