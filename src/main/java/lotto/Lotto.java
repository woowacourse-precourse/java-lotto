package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int compareNumbers(List<Integer> issuedNumbers) {
        int count = 0;
        for (Integer issuedNumber : issuedNumbers) {
            if (numbers.contains(issuedNumber)) {
                count++;
            }
        }
        return count;
    }
    public boolean compareBonus(int bonus) {
        if (numbers.contains(bonus)) {
            return true;
        }
        return false;
    }
}
