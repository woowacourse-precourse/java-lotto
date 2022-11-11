package lotto.utils;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String SEPARATOR = ",";
    public static Integer parseToInteger(String singleLine) {
        try {
            return Integer.parseInt(singleLine.trim());
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public static ArrayList<String> divideInputBySeparator(String input) {
        return new ArrayList<>(List.of(input.split(SEPARATOR)));
    }

    public static ArrayList<Integer> parseAllElementToInteger(
            ArrayList<String> input
    ) {
        ArrayList<Integer> parseCompleted = new ArrayList<>();

        for(String toBeParse : input) {
            parseCompleted.add(parseToInteger(toBeParse));
        }

        return parseCompleted;
    }
}
