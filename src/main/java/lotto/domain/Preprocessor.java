package lotto.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Preprocessor {
    public static int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

    public static String convertIntToString(int number) {
        return Integer.toString(number);
    }

    public static List<Integer> convertStringListToIntegerList(List<String> lottoNumbers) {
        return lottoNumbers.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> splitNumber(String number) {
        String[] numbers = number.split(",");

        return new ArrayList<String>(Arrays.asList(numbers));
    }

    public static String addNumberPunctuation(Number prizeMoney) {
        return NumberFormat.getInstance().format(prizeMoney);
    }
}
