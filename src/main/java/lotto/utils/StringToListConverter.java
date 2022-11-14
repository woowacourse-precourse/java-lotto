package lotto.utils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringToListConverter implements Converter<String, List<Integer>> {
    @Override
    public List<Integer> convert(String winningNumber) {
        String[] winningNumbers = validateSeparator(winningNumber);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static String[] validateSeparator(String winningNumber) {
        String[] winningNumbers = winningNumber.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표(,)를 이용하여 구분하여 입력해 주시기 바랍니다");
        }
        return winningNumbers;
    }
}
