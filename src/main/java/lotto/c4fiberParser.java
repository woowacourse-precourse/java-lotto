package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class c4fiberParser {
    public static Integer getIntegerFromString(String input) {
        if (isParsable(input)) {
            Integer.parseInt(input);
        }

        return 0;
    }

    public static List<Integer> getIntegerListFromString(String input) {
        if (isParsable(input)) {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
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
