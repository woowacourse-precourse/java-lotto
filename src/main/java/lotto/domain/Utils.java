package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    public static final Pattern PATTERN = Pattern.compile("^[\\d]+, [\\d]+, [\\d]+, [\\d]+, [\\d]+, [\\d]+$");

    public static int textToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력해야 합니다.");
        }
    }

    public static List<Integer> separateNums(String input) {
        return Arrays.asList(input.split(", "))
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
