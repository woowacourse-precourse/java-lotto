package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.message.ExceptionMessage;

public class Lotto {
    public static final int LOTTO_COUNT = 6;
    public static final String START_SYMBOL = "[";
    public static final int ONE = 1;
    public static final String COMMA = ",";
    private static final String END_SYMBOL = "]";
    private static final String SPACE = " ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.NUMERIC_LENGTH);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctNumbers.size() != LOTTO_COUNT;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String createMessage() {
        StringBuilder lottoResult = new StringBuilder();
        lottoResult.append(START_SYMBOL);
        numbers.stream()
                .limit(numbers.size() - ONE)
                .forEach(number -> lottoResult.append(number)
                        .append(COMMA)
                        .append(SPACE));
        return lottoResult.append(numbers.get(numbers.size() - ONE))
                .append(END_SYMBOL)
                .toString();
    }
}
