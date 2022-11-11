package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해주세요.");
        }
        checkDuplication(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplication(List<Integer> numbers) {
        List<Integer> check = new ArrayList<>();

        check.add(numbers.get(0));
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
            if (i != 0 && check.contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
            }
            if (i != 0)
                check.add(numbers.get(i));
        }
    }
}
