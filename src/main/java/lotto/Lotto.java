package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println("[ERROR] 입력 크기가 초과했습니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void checkDuplicate(List<Integer> numbers) {

        List<Integer> visitedNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            int current = numbers.get(i);

            if (visitedNumbers.contains(current)) {
                System.out.println("[ERROR] 중복된 숫자가 있습니다.");
                throw new IllegalArgumentException();
            }

            visitedNumbers.add(current);
        }
    }

    public Integer getLottoNumber(int LottoIndex) {
        return numbers.get(LottoIndex);
    }
}
