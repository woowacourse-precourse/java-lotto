package lotto.utils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.resources.ValidationPattern.WINNING_NUMBER;

public class StringToListConverter implements Converter<String, List<Integer>> {
    @Override
    public List<Integer> convert(String winningNumber) {
        String[] winningNumbers = validateSeparator(winningNumber);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static String[] validateSeparator(String winningNumber) {
        if(WINNING_NUMBER.isValid(winningNumber)){
            return winningNumber.split(",");
        }
        throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표(,)를 이용하여 구분하여 입력해 주시기 바랍니다");
    }
}
