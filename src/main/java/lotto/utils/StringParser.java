package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public final class StringParser {
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
        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i == 5) {
                break;
            }
            sb.append(", ");
        }
        sb.append("]");
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
