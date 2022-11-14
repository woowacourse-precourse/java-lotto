package lotto;

import java.util.List;

public class Lotto {
    static final Integer cost = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개가 넘는 숫자 입력");
        }

        Long nonDuplicatedElementCnt = numbers.stream().distinct().count();

        if(numbers.size() != nonDuplicatedElementCnt.intValue()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자 입력");
        }
    }

    // TODO: 추가 기능 구현
}
