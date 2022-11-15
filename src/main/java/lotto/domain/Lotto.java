package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sameNumber(numbers);
        wrongNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Print.lottoNumberError());
        }
    }

    // TODO: 추가 기능 구현
    private void sameNumber(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++){
            if (Collections.frequency(numbers, numbers.get(i)) > 1){
                throw new IllegalArgumentException(Print.lottoNumberError());
            }
        }
    }

    private void wrongNumber(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException(Print.lottoNumberError());
            }
        }
    }
}
