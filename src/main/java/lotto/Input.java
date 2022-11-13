package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static String readString() {
        return Console.readLine();
    }

    public static int readInteger() {
        try {
            return Integer.parseInt(readString());
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_PARSING_NUMBER.getValue());
        }
    }

    public static long readLong() {
        try {
            return Long.parseLong(readString());
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_PARSING_NUMBER.getValue());
        }
    }

    public static List<Integer> readListInteger(String seperator) {
        String input = readString();
        String[] inputs = input.split(seperator);
        List<Integer> separateInput = new ArrayList<>();
        for (int inputIndex = 0; inputIndex < inputs.length; inputIndex++) {
            try {
                separateInput.add(Integer.parseInt(inputs[inputIndex]));
            } catch (Exception e) {
                throw new IllegalArgumentException(Error.ERROR_INPUT_PARSING_NUMBER.getValue());
            }
        }
        return separateInput;
    }
}
