package lotto.view.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.Format;
import lotto.view.validator.IOValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeyboardReader {
    private KeyboardReader() { }

    public static List<Integer> readFormattedStringToInteger(Format delimiter) throws IllegalArgumentException {
        String readValue = readLine();
        String delimterValue = delimiter.getText();
        IOValidator.validateFormattedStringToInteger(readValue, delimterValue);
        return Arrays.stream(readValue.split(delimterValue))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readInteger() throws IllegalArgumentException {
        String readValue = readLine();
        IOValidator.validateStringToInteger(readValue);
        return Integer.parseInt(readValue);
    }

    public static String readLine() {
        return Console.readLine();
    }
}
