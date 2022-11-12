package lotto.view.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtil {
    public static Integer stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public static List<String> stringToList(String string) {
        return Stream.of(string.split(","))
                .collect(Collectors.toList());
    }

    public static List<Integer> stringListToIntegerList(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
