package lotto;

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
        if (!isValidRange(numbers)){
            throw new IllegalArgumentException();
        }
        if (hasSameNumber(numbers)){
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    // TODO: 예외 사항 구현

    private Boolean isValidRange(List<Integer> numbers){
        for (int number: numbers){
            if (number < 1 || number > 45){
                return false;
            }
        }
        return true;
    }

    private Boolean hasSameNumber(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count()){
            return true;
        }
        return false;
    }
}
