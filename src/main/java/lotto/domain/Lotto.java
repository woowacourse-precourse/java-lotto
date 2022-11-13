package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final String ERROR_NOT_6 = "[ERROR] 로또 번호의 개수가 6개가 아닙니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String ERROR_RANGEOUT_NUMBER = "[ERROR] 번호가 1 ~ 45의 범위를 초과했습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        rangeOutvalidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NOT_6);
        }
    }

    // TODO: 추가 기능 구현
    private void duplicateValidate(List<Integer> numbers) {
        List<Integer> number = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (number.contains(numbers.get(i))) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
            }
            number.add(numbers.get(i));
        }
    }

    private void rangeOutvalidate(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new IllegalArgumentException(ERROR_RANGEOUT_NUMBER);
            }
        }
    }

    public int bonusValidate(int bonus) {
        duplicateByBonus(bonus);
        rangeOutByBonus(bonus);
        return bonus;
    }

    private void rangeOutByBonus(int bonus) {
        if (bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException(ERROR_RANGEOUT_NUMBER);
        }
    }

    public void duplicateByBonus(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
