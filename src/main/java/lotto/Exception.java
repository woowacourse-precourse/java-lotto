package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exception {
    public static final String PURCHASE_MONEY_INTEGER = "[ERROR] 구입 금액은 정수를 입력해야 합니다.";
    public static final String WINING_NUMBER_INTEGER = "[ERROR] 당첨 번호는 정수를 입력해야 합니다.";

    public static int isInteger(String str) {
        int integer = 0;

        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_MONEY_INTEGER);
        }

        return integer;
    }

    public static boolean isNotMultipleOfThousand(int money) {
        return money % 1000 != 0;
    }

    public static boolean isNotPositive(int money) {
        return money <= 0;
    }

    public static List<Integer> changeListStringToInteger(List<String> stringList) {
        List<Integer> integerList;

        try {
            integerList = stringList.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINING_NUMBER_INTEGER);
        }

        return integerList;
    }
}
