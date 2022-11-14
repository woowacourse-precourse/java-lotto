package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoScanner {
    private static final String READ_MONEY_PROMPT = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    public static final String REQUIRE_NUMERIC_VALUE = "숫자를 입력해주세요.";
    public static final String SHOULD_BE_DIVIDED_BY_1000 = "구입금액은 1000으로 나누어 떨어져야합니다.";
    public static final String DO_NOT_INCLUDE_NUMERIC_VALUE = "숫자가 아닌 문자가 있습니다.";

    public static int readMoney() {
        System.out.println(READ_MONEY_PROMPT);
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(REQUIRE_NUMERIC_VALUE);
        }
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException(SHOULD_BE_DIVIDED_BY_1000);
        }
        return money;
    }

    public static WinningNumber readWinningNumber() {
        List<Integer> numbers = readSixNumbers();
        int bonusNumber = readBonusNumber();
        return new WinningNumber(numbers, bonusNumber);
    }

    private static List<Integer> readSixNumbers() {
        System.out.println(READ_WINNING_NUMBER_PROMPT);

        String[] numbersSplitByDelimiter = Console.readLine().split(DELIMITER);

        List<Integer> parsedNumbers = Arrays.stream(numbersSplitByDelimiter)
                .mapToInt(LottoScanner::parseIntOrThrowException)
                .boxed().collect(Collectors.toList());

        return parsedNumbers;
    }

    private static Integer parseIntOrThrowException(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DO_NOT_INCLUDE_NUMERIC_VALUE);
        }
    }


    private static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_PROMPT);
        return Integer.parseInt(Console.readLine());
    }

}