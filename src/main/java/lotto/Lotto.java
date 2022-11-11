package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        WinningNumber winningNumber = new WinningNumber();
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력해주세요.");
        }
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
        }
//        if (!winningNumber.numberRangeCheck(numbers)) {
//            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
//        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> properNumber() {
        return this.numbers;
    }

}
