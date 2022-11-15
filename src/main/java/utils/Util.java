package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private static final String REGEX = ",";

    public static int convertStringToInt(String textNumber) {
        return Integer.parseInt(textNumber);
    }

    public static List<Integer> separateNumberWithComma(String textNumbers) {
        return Arrays.stream(textNumbers.split(REGEX))
                .map(Util::convertStringToInt)
                .collect(Collectors.toList());
    }

}
