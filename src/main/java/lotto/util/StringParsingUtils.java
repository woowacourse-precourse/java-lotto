package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParsingUtils {
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";

    private static final String COMMA = ",";

    public static List<Integer> parseToNumber(String input) {
        String[] stringParsedInput = input.split(COMMA);

        for (int i = 0; i < stringParsedInput.length; i++) {
            try {
                Integer.parseInt(stringParsedInput[i]);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
            }
        }

        return Arrays.stream(stringParsedInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
