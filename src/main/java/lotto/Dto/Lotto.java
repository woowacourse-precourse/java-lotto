package lotto.Dto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 길이가 6이 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    public String toString(){

        return numbers.toString();
    }
}
