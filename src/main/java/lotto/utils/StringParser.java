package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public final class StringParser {
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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자를 입력해야 합니다.");
        }
    }
}
