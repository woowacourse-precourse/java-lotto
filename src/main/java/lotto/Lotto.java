package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력해주세요.");
        }
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> properNumber() {
        return this.numbers;
    }

}
