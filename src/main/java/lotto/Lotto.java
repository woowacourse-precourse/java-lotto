package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        Validation validation = new Validation();
        validation.checkDuplicate(numbers);
        for(int number : numbers){
            validation.checkNumberInRange(number);
        }
    }

    // TODO: 추가 기능 구현
}
