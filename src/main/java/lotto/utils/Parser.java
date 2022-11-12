package lotto.utils;

import org.assertj.core.util.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static int convertStringToInt(String input) {
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

}
