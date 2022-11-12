package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> setlottonumber = new HashSet<>(numbers);
        if(setlottonumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 동일한 로또 번호가 입력되었습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
