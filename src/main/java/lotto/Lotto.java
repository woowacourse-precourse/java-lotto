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
        for (Integer number : numbers) {
            checkException(number);
            duplicateException(numbers, number);
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
    private void duplicateException(List<Integer> numbers, int num) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) {
                count++;
            }
            if (count > 1) {
                throw new IllegalArgumentException();
            }
        }
    }
    private void checkException(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
    }
    public void checkBonusException(int num) {
        if (num < 1 || num > 45 || numbers.contains(num)) {
            throw new IllegalArgumentException();
        }
    }
}
