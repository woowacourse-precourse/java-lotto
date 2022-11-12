package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static int StringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static int countLotto(int amount) {
        return (int) amount / 1000;
    }

    public static List<Integer> seperateCommas(String input) {
        String[] seperated = input.split(",");
        Validation.validateSeperatedNumbers(seperated);
        return Parser.ArrayToList(seperated).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<String> ArrayToList(String[] input) {
        return Stream.of(input).collect(Collectors.toList());
    }

    public static List<String> unionUserNumber(List<Integer> userNumber, String number) {
        List<String> stringUserNumber = userNumber.stream().map(String::valueOf).collect(Collectors.toList());
        stringUserNumber.add(number);
        return stringUserNumber;
    }
}
