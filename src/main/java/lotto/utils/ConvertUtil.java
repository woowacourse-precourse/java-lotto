package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

    private ConvertUtil() {
    }

    public static List<Integer> convertInputToIntegerList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
