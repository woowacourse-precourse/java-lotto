package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 가능합니다.");
        }
    }
    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDulicationNumbers = new HashSet<>(numbers);

        if (nonDulicationNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> setLotto() {
        return numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public void ascendingOrderSort() {
        Collections.sort(numbers);
    }
}
