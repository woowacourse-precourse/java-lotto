package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateOverNum(numbers);
        validateNotMatchMoney(numbers);
        validateNotMatchNum(numbers);
        sorting(numbers);
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

    private void validateNotMatchNum(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (45 < numbers.get(i) || numbers.get(i) < 1) {
                System.out.println("[ERROR] 로또 번호가 1부터 45 이내에 있지 않음");
                throw new IllegalArgumentException();
            }
        }
    }

    private void sorting(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
