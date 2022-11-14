package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSeparator {
    private static String SPLIT_DELIMITER = ",";

    public List<Integer> separateStringToList(String inputNumber) {
        return Arrays.stream(inputNumber.split(SPLIT_DELIMITER))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
