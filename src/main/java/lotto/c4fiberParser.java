package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class c4fiberParser {
    public static Integer getIntegerFromString(String input) {
        if (!isParsable(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> getIntegerListFromString(String input) {
        if (!isParsable(input)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isParsable(String input) {
        try {
            for (String s : input.split(",")){
                Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Can't parse to Int");
            return false;
        }

        return true;
    }
}
