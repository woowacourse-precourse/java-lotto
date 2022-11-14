package lotto;

import java.util.List;

import static lotto.Validators.*;

public class Lotto {
    private final List<Integer> numbers;

    private final static int LOTTERY_LENGTH = 6;
    private final static int RANGE_MIN = 1;
    private final static int RANGE_MAX = 45;
    private final static int SECOND_THIRD_MATCH = 5;
    private final static int FIFTH_MATCH = 3;

    private final static int FIRST_PRIZE = 2000000000;
    private final static int SECOND_PRIZE = 30000000;
    private final static int THIRD_PRIZE = 1500000;
    private final static int FOURTH_PRIZE = 50000;
    private final static int FIFTH_PRIZE = 5000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersUniqueness(numbers);

        validateNumbersRange(numbers);
    }


}
