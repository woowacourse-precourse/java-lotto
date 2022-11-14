package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;
    private static final int START_INDEX = 0;
    private static final String INVALID_INPUT_COUNT_MESSAGE = "[ERROR] 로또는 " + LOTTO_NUMBER_SIZE + "개의 번호를 입력해야 합니다.";
    private static final String INVALID_NUMBER_RANGE_MESSAGE = "[ERROR] 로또는 " + LOTTO_START_RANGE + "부터 " + LOTTO_END_RANGE + "까지의 숫자를 입력해야 합니다. 문제가 생긴 값 = ";
    private static final String INVALID_DUPLICATED_NUMBER_MESSAGE = "[ERROR] 중복된 숫자가 포함되어서는 안됩니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() == LOTTO_NUMBER_SIZE) {
            return;
        }
        System.out.println(INVALID_INPUT_COUNT_MESSAGE);
        throw new IllegalArgumentException(INVALID_INPUT_COUNT_MESSAGE);
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number >= LOTTO_START_RANGE && number <= LOTTO_END_RANGE) {
                continue;
            }
            System.out.println(INVALID_NUMBER_RANGE_MESSAGE + number);
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE + number);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() == uniqueNumbers.size()) {
            return;
        }
        System.out.println(INVALID_DUPLICATED_NUMBER_MESSAGE);
        throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER_MESSAGE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Result generateResult(Lotto winningLotto, Bonus bonus) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        Result result = new Result();

        for (int i = START_INDEX; i < winningNumbers.size(); i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                result.increaseMatchCount();
            }

            if (result.isFiveHit() && numbers.contains(bonus.getNumber())) {
                result.matchBonus();
            }
        }
        return result;
    }
}
