package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.Game.MAX_NUMBER;
import static lotto.Game.MIN_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
        if (isDifferentNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 6개 번호여야 합니다.");
        }
        if (!checkNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean isDifferentNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    private boolean checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
                return false;
            }
        }
        return true;
    }

    public void validateBonus(List<Integer> numbers) {

    }

}
