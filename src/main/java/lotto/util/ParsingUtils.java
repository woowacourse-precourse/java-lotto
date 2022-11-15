package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ParsingUtils {
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";

    public static int stringToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        return number;
    }

    public static List<Integer> stringToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String splitString : input.split(",")) {
            numbers.add(stringToInt(splitString));
        }

        return numbers;
    }
}
