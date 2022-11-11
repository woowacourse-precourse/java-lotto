package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private final static String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String GET_WIN_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String WIN_LOTTO_REGEX = "^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$";
    private static final String SPLIT_REGEX = ",";
    private static final String GET_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int getMoneyInput() {
        System.out.println(GET_MONEY_MESSAGE);
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

    public static List<Integer> getWinLotto() {
        System.out.println(GET_WIN_LOTTO_MESSAGE);
        String input = Console.readLine();
        validateWinLotto(input);
        return Arrays.stream(input.split(SPLIT_REGEX)).map(InputView::toNumbers)
            .collect(Collectors.toList());
    }

    private static void validateWinLotto(String input) {
        if (!Pattern.matches(WIN_LOTTO_REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
        }
    }

    public static int getBonus() {
        System.out.println(GET_BONUS_MESSAGE);
        String input = Console.readLine();
        validate(input);
        return toNumbers(input);
    }

}
