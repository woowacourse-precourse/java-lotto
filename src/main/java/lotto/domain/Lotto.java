package lotto.domain;

import static lotto.Constant.BALL_MAX_RANGE;
import static lotto.Constant.BALL_MIN_RANGE;
import static lotto.Constant.LOTTO_DIGIT_CNT;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_DIGIT_CNT) {
            throw new IllegalArgumentException("여섯개의 숫자를 입력해야 합니다");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다");
        }

        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해야 합니다");
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        int filteredCnt = (int) numbers.stream().filter(number -> BALL_MIN_RANGE <= number)
                .filter(number -> number <= BALL_MAX_RANGE)
                .count();
        return filteredCnt != LOTTO_DIGIT_CNT;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_DIGIT_CNT;
    }

    public boolean has(Integer number) {
        return numbers.contains(number);
    }

    public Integer countOverlappingBalls(Lotto winningNumber) {
        return (int) numbers.stream().filter(winningNumber::has)
                .count();
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
