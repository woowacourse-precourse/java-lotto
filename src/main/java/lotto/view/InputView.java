package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private final static String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String GET_WIN_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String WIN_LOTTO_REGEX = "^\\d+,\\d+,\\d+,\\d+,\\d+,\\d+$";
    private static final String SPLIT_REGEX = ",";
    private static final String GET_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String INVALID_MONEY_FORMAT_MESSAGE = "[ERROR] 숫자만 입력해주세요. : %s";
    private static final String INVALID_FORMAT_MESSAGE = "[ERROR] 입력 형식이 올바르지 않습니다. : %s";

    public static int getMoneyInput() {
        System.out.println(GET_MONEY_MESSAGE);
        String input = Console.readLine();
        validate(input);
        return toNumber(input);
    }

    private static void validate(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(String.format(INVALID_MONEY_FORMAT_MESSAGE, input));
        }
    }

    private static int toNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinLotto() {
        System.out.println(GET_WIN_LOTTO_MESSAGE);
        String input = Console.readLine();
        validateWinLotto(input);
        return Arrays.stream(input.split(SPLIT_REGEX)).map(InputView::toNumber)
            .collect(Collectors.toList());
    }

    private static void validateWinLotto(String input) {
        if (!Pattern.matches(WIN_LOTTO_REGEX, input)) {
            throw new IllegalArgumentException(String.format(INVALID_FORMAT_MESSAGE, input));
        }
    }

    public static int getBonus() {
        System.out.println(GET_BONUS_MESSAGE);
        String input = Console.readLine();
        validate(input);
        return toNumber(input);
    }

}
