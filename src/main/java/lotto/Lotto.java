package lotto;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateOverNum(numbers);
        validateDuplicate(numbers);
        validateNotMatchNum(numbers);
        this.numbers = numbers;
    }

    private void validateOverNum(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 개수가 6개를 초과했습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) == numbers.get(i + 1)) {
                System.out.println("[ERROR] 로또 나열번호에 중복된 숫자가 존재합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNotMatchNum(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (45 < numbers.get(i) || numbers.get(i) < 1) {
                System.out.println("[ERROR] 로또 번호가 1부터 45 이내에 있지 않습니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
