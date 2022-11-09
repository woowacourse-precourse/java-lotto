package lotto;

import java.util.List;

public class Lotto {

    public static final int CRITERION_LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != CRITERION_LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개 이어야 합니다.");
        }
    }

}
