package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {
    public static List<Integer> convertStringListToIntegerList(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
