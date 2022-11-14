package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        notDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자여야 합니다.");
        }
    }

    private void notDuplicate(List<Integer> numbers) {
//        if () {
//            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자여야 합니다.");
//        }
    }

}
