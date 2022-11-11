package lotto.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    public static int toIntFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static List<Integer> toIntList(String winningNumber) {
        try {
            return Arrays.stream(winningNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static List<String> toWinningResults(Map<String, Integer> resultMap) {
        String messageLayout = "%s (%s원) - %s개";
        DecimalFormat decFormat = new DecimalFormat("###,###");

        return new ArrayList<>(resultMap.keySet()).stream()
                .map(key -> String.format(messageLayout,
                        Winning.getCountByLabel(key),
                        decFormat.format(Winning.getPrizeByLabel(key)),
                        resultMap.get(key)))
                .collect(Collectors.toList());
    }
}
