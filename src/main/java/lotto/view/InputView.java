package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private final static String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static int getMoneyInput() {
        System.out.println(MONEY_MESSAGE);
        String input = Console.readLine();
        validate(input);
        return toNumbers(input);
    }

    private static void validate(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static int toNumbers(String input) {
        return Integer.parseInt(input);
    }

}
