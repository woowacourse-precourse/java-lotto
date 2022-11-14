package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoScanner {
    private static final String READ_MONEY_PROMPT = "구입금액을 입력해 주세요.";
    public static final String REQUIRE_NUMERIC_VALUE = "숫자를 입력해주세요.";
    public static final String SHOULD_BE_DIVIDED_BY_1000 = "구입금액은 1000으로 나누어 떨어져야합니다.";

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
}
