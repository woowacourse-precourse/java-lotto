package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호 개수는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Map<Integer, Integer> duplicateChecker = new HashMap<>();
        numbers.forEach(x -> duplicateChecker.put(x, duplicateChecker.getOrDefault(x,0)+1));

        for(int x : duplicateChecker.values()) {
            if (x > 1) {
                throw new IllegalArgumentException("[ERROR] 로또의 번호는 중복될 수 없습니다.");
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        long countsOfRangeOut = numbers.stream().filter(x -> x < 1 || x > 45).count();
        if (countsOfRangeOut > 0) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자 범위는 1에서 45까지 가능합니다.");
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
