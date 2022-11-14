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
            throw new IllegalArgumentException("ERROR : 로또 번호는 6개의 숫자로 이루어져야합니다. ");
        }
        for(int i = 0; i < numbers.size(); i++) {
            if (!(numbers.get(i) >= 1 && numbers.get(i) <= 45)) {
                throw new IllegalArgumentException("ERROR : 로또 번호는 1~45 사이의 숫자입니다..");
            }

            if (Collections.frequency(numbers, numbers.get(i)) != 1) {
                throw new IllegalArgumentException("ERROR : 로또 번호는 중복될 수 없습니다.");
            }

            // TODO: 추가 기능 구현
        }
    }
}
