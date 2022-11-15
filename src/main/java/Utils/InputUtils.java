package Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtils {
    private static final int LOTTO_LENGTH = 6;

    public static boolean isMultipleOfOneThousand(String input) {
        final int THOUSAND_WON = 1000;
        int number = Integer.parseInt(input);
        return number % THOUSAND_WON == 0;
    }

    public static boolean isNumberLengthSix(List<Integer> input) {
        return input.size() == LOTTO_LENGTH;
    }

    public static boolean isInputSplitWithComma(String input) {
        List<String> inputs = splitPlayerInput(input);
        return inputs.size() == LOTTO_LENGTH;
    }

    public static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumberInLottoRange(String input) {
        final int startNumber = 1;
        final int endNumber = 45;
        int number = Integer.parseInt(input);
        return number >= startNumber && number <= endNumber;
    }


    public static List<String> splitPlayerInput(String input) {
        final String COMMA = ",";
        return Stream.of(input.split(COMMA))
                .collect(Collectors.toList());
    }
}
