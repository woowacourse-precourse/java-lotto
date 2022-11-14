package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException{
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호에는 중복된 숫자가 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }

    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            System.out.println("로또 번호는 총 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
}
