package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateOverNum(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 개수가 6개 초과");
            throw new IllegalArgumentException();
        }
    }

    private void validateNotMatchMoney(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) == numbers.get(i + 1)) {
                System.out.println("[ERROR] 로또 번호에 중복된 숫자 존재");
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
