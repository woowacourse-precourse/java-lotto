package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.Game.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + BALL_COUNT +"개여야 합니다.");
        }
        if (isDifferentNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 " + BALL_COUNT + "개 번호여야 합니다.");
        }
        checkNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    private boolean isDifferentNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    private void checkNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 "+ MIN_NUMBER +"부터 " + MAX_NUMBER + "사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateBonus(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        checkNumberRange(numbers);
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호 외의 번호를 입력해야 합니다.");
        }
    }

}
