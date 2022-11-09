package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final String INVALID_RANGE_INPUT = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INVALID_SIZE_INPUT = "로또 번호는 6개의 숫자여야 합니다.";
    private static final String DUPLICATED_INPUT = "로또 번호는 중복되지 않습니다.";
    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            LottoError.illegalArgumentException(INVALID_SIZE_INPUT);
        }
        Boolean[] isUnique = new Boolean[6];
        Arrays.fill(isUnique, false);
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                LottoError.illegalArgumentException(INVALID_RANGE_INPUT);
            }
            if (isUnique[number - 1]) {
                LottoError.illegalArgumentException(DUPLICATED_INPUT);
            }
            isUnique[number - 1] = true;
        }
    }


}
