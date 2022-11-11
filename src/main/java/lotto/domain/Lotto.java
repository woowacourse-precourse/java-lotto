package lotto.domain;

import java.util.List;

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

        // 중복된 숫자가 존재할 경우 예외처리
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (!isCorrectRange(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private Boolean isCorrectRange(Integer number){
        return 1 <= number && number <= 45;
    }

    // TODO: 추가 기능 구현
}
