package lotto.utils;

import lotto.domain.Lotto;

import java.util.List;

public final class StringParser {
    private StringParser() {}

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
}
