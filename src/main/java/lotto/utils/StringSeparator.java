package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringSeparator {
    private static String SPLIT_DELIMITER = ",";

    public List<Integer> separateStringToList(String inputNumber) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : inputNumber.split(SPLIT_DELIMITER)) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
