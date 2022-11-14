package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException("[ERROR] 입력된 로또 번호에 중복된 번호가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
