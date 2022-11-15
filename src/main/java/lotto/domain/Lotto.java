package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또의 번호 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Map<Integer, Integer> duplicateChecker = new HashMap<>();
        numbers.forEach(x -> duplicateChecker.put(x, duplicateChecker.getOrDefault(x,0)+1));

        for(int x : duplicateChecker.values()) {
            if (x > 1) {
                System.out.println("[ERROR] 로또의 번호는 중복될 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        long countsOfRangeOut = numbers.stream().filter(x -> x < 1 || x > 45).count();
        if (countsOfRangeOut > 0) {
            System.out.println("[ERROR] 로또의 숫자 범위는 1에서 45까지 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
