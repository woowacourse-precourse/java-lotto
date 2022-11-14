package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessages;

public class Lotto {

    public static final int NUMBER_COUNT = 6;
    public static final int NUMBER_RANGE_START = 1;
    public static final int NUMBER_RANGE_END = 45;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNonDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            System.out.println(ErrorMessages.NUMBER_SIZE);
            throw new IllegalArgumentException();
        }
    }

    private void validateNonDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                System.out.println(ErrorMessages.NUMBER_DUPLICATE);
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!isLottoNumber(number)) {
                System.out.println(ErrorMessages.NUMBER_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean isLottoNumber(int number) {
        return NUMBER_RANGE_START <= number && number <= NUMBER_RANGE_END;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countSameNumber(Lotto other) {
        int count = 0;

        for (Integer number : numbers) {
            if (other.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
