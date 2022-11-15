package lotto.utils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Converter {
    public static int toIntFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_ERROR.getMessage());
        }
    }

    public static List<Integer> toIntList(String winningNumber) {
        try {
            return Arrays.stream(winningNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_ERROR.getMessage());
        }
    }

    public static List<String> toWinningResults(Map<String, Integer> resultMap) {
        String messageLayout = "%s (%s¿ø) - %s°³";
        DecimalFormat decFormat = new DecimalFormat("###,###");

        return new ArrayList<>(resultMap.keySet()).stream()
                .map(key -> String.format(messageLayout,
                        Winning.getCountByLabel(key),
                        decFormat.format(Winning.getPrizeByLabel(key)),
                        resultMap.get(key)))
                .collect(Collectors.toList());
    }

    public static List<Integer> sortList(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }
}