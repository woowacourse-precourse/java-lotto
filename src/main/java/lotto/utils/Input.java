package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static String readString() {
        return Console.readLine()
                .trim();
    }

    public static int readInteger() {
        String input = readString();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public static long readLong() throws IllegalArgumentException {

        String input = readString();
            validateNumber(input);

        return Long.parseLong(input);
    }

    public static List<Integer> readListInteger(String seperator) {
        String input = readString();
        String[] inputs = input.split(seperator);
        List<Integer> separateInput = new ArrayList<>();
        for (int inputIndex = 0; inputIndex < inputs.length; inputIndex++) {
            String elementInput = inputs[inputIndex];
            validateNumber(elementInput);
            separateInput.add(Integer.parseInt(elementInput));
        }
        return separateInput;
    }

    private static void validateNumber(String input) throws IllegalArgumentException{
        if (input.matches("[0-9]*[^0-9]+[0-9]*")) {
            throw new IllegalArgumentException(Errors.ERROR_INPUT_PARSING_NUMBER.getValue());
        }
    }
}
