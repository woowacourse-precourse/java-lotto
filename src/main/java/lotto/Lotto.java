package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 6이 아닙니다.");
        }
        for(Integer i: numbers){
            if(Collections.frequency(numbers, i) != 1)
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 숫자가 있습니다.");
            if(!(1<=i&&i<=45))
                throw new IllegalArgumentException("[ERROR] 로또 번호가 1-45이내의 숫자가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
}
