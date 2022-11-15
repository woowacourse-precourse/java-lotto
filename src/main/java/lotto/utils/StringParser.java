package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public final class StringParser {
    private static final int START_INDEX = 0;
    private static final int FIVE_MATCHED_COUNT = 5;
    private static final String OPEN_SQUARE_BRACKET = "[";
    private static final String COMMA = ", ";
    private static final String CLOSE_SQUARE_BRACKET = "]";
    private static final String INVALID_PARSE_STRING_TO_INTEGER_MESSAGE = "[ERROR] 로또 번호는 숫자를 입력해야 합니다.";
    private StringParser() {
    }

    public static List<Integer> parseInputToIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputSplits = input.split(",");
        for (String inputSplit : inputSplits) {
            validateParseStringToInt(inputSplit);
            numbers.add(Integer.parseInt(inputSplit));
        }
        return numbers;
    }

    public static String parseLottoToString(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();
        sb.append(OPEN_SQUARE_BRACKET);
        for (int i = START_INDEX; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i == FIVE_MATCHED_COUNT) {
                break;
            }
            sb.append(COMMA);
        }
        sb.append(CLOSE_SQUARE_BRACKET);
        return sb.toString();
    }

    private static void validateParseStringToInt(String inputSplit) {
        try {
            Integer.parseInt(inputSplit);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_PARSE_STRING_TO_INTEGER_MESSAGE);
            throw new IllegalArgumentException(INVALID_PARSE_STRING_TO_INTEGER_MESSAGE);
        }
    }
}
