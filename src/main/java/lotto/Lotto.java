package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> duplicateNumber = numbers.stream().distinct().collect(Collectors.toList());
        if (duplicateNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 같은 로또 번호는 존재할 수 없습니다.");
        }
    }

    public int compare(Lotto compareNumbers) {
        int count = 0;
        List<Integer> winningNumbers = compareNumbers.getNumbers();

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBonus(int bonus) {
        if (numbers.contains(bonus)) {
            return true;
        }
        return false;
    }
}