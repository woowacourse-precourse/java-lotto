package lotto.domain;

import lotto.utils.UserInputValidator;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;
    private static final String COMMA = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
//        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(UserInputValidator.ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return OPEN_BRACKET + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA)) + CLOSED_BRACKET;
    }
}
