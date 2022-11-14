package domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateCheckSet = new HashSet<>();
        for (int number : numbers) {
            if (!duplicateCheckSet.add(number)){
                throw new IllegalArgumentException("당첨 번호 가운데 중복된 숫자가 없어야 합니다.");
            }
        }
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getLottoSize() {
        return numbers.size();
    }

    public int getLottoNumber(int index) {
        return numbers.get(index);
    }
}