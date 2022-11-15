package lotto.domain.getwin.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다");
        }
        if (!numbersInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (!numbersAllDifferent(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    private boolean numbersInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++)
            if ((numbers.get(i) < 1) || (numbers.get(i) > 45))
                return false;
        return true;
    }

    private boolean numbersAllDifferent(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int tmp = numbers.get(i);
            if (Collections.frequency(numbers, tmp) > 1)
                return false;
        }
        return true;
    }
}
