package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("번호의 갯수가 6이 아닙니다.");
        }
    }

    public List<Integer> getAutoNumbers(){
        return numbers;
    }
}
