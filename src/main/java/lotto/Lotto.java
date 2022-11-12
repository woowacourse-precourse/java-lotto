package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        if (numbers.size() == numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 중복일 수 없습니다.");
        }
            validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현
}
