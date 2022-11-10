package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private final static int RANGE_MIN = 1;
    private final static int RANGE_MAX = 45;

    private final static int FIRST_PLACE_MATCHES = 6;
    private final static int SECOND_THIRD_PLACE_MATCHES = 5;
    private final static int FOURTH_PLACE_MATCHES = 4;
    private final static int FIFTH_PLACE_MATCHES = 3;

    private final static int FIRST_PRIZE = 2000000000;
    private final static int SECOND_PRIZE = 30000000;
    private final static int THIRD_PRIZE = 1500000;
    private final static int FOURTH_PRIZE = 50000;
    private final static int FIFTH_PRIZE = 5000;

    private final static int PRICE_PER_LOTTERY = 1000;

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final static String EXCEPTION_ONE = "로또 번호는 1부터 45사이의 숫자여야 합니다.";
    private final static String EXCEPTION_TWO = "구입금액은 1000으로 나누어 떨어지는 숫자여야 합니다.";
    private final static String EXCETPION_THREE = "당첨 번호는 쉼표로 구분된 6개의 숫자들이여야 합니다.";

    private enum Places {
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
