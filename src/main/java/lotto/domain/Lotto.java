package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LENGTH_OF_WINNING_NUMBER = 6;
    private static final int NUMBER_MIN_RANGE = 1;
    private static final int NUMBER_MAX_RANGE = 45;
    private static final String ERR_UNLIKE_NUMBER = "[ERROR] 당첨번호는 중복되지 않아야합니다. ";
    private static final String ERR_WRONG_LENGTH_OF_LOTTO = "[ERROR] 로또 번호는 6개여야 합니다. ";
    private static final String ERR_WRONG_NUMBER_RANGE = "[ERROR] 당첨 번호는 1~45 숫자여야 합니다. ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validationLotto(numbers);
        this.numbers = numbers;
    }

    public void validationLotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
        validateOverlap(numbers);
        validateLengthOfLotto(numbers);
    }

    public void validateLengthOfLotto(List<Integer> lottoNumber) {
        if (lottoNumber.size() != LENGTH_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(ERR_WRONG_LENGTH_OF_LOTTO);
        }
    }

    public void validateNumberInRange(int number) {
        if (number < NUMBER_MIN_RANGE || NUMBER_MAX_RANGE < number) {
            throw new IllegalArgumentException(ERR_WRONG_NUMBER_RANGE);
        }
    }

    public void validateOverlap(List<Integer> numbers) {
        numbers = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != LENGTH_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(ERR_UNLIKE_NUMBER);
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}
