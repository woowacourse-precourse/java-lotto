package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private static final String NUMBERS_COUNT_ERROR_MESSAGE = "[ERROR] 번호의 개수가 6개가 아닙니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 번호가 있습니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45의 번호가 아닙니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Boolean[] isIncluded = new Boolean[46];
        Arrays.fill(isIncluded, false);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_COUNT_ERROR_MESSAGE);
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
            if (isIncluded[number]) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
            isIncluded[number] = true;
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
