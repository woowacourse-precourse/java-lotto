package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringSeparator {
    public List<Integer> separateStringToList(String inputNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumber.split(",")) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
