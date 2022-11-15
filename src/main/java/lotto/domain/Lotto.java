package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_BEGIN = 1;
    public static final int LOTTO_NUMBER_END = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현
    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                String.format("로또 번호의 개수가 %d개가 아닙니다.", LOTTO_NUMBER_SIZE));
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isInvalidRange)) {
            throw new IllegalArgumentException(
                String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_NUMBER_BEGIN,
                    LOTTO_NUMBER_END));
        }
    }

    boolean isInvalidRange(int number) {
        return number < LOTTO_NUMBER_BEGIN || number > LOTTO_NUMBER_END;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
