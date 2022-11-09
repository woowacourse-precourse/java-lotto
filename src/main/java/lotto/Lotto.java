package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final String INVALID_RANGE_INPUT =
            "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_SIZE_INPUT =
            "로또 번호는 6개의 숫자여야 합니다.";
    public static final String DUPLICATED_INPUT =
            "로또 번호는 중복되지 않습니다.";
    public static final int SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            LottoError.illegalArgumentException(INVALID_SIZE_INPUT);
        }
        Boolean[] isUnique = new Boolean[6];
        Arrays.fill(isUnique, false);
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                LottoError.illegalArgumentException(INVALID_RANGE_INPUT);
            }
            if (isUnique[number - 1]) {
                LottoError.illegalArgumentException(DUPLICATED_INPUT);
            }
            isUnique[number - 1] = true;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(integer -> toString())
                .collect(Collectors.joining(",")) + "]";
    }
}
