package lotto.domain;

import java.util.List;

public class Lotto {

    private static final String SIX_NUMBER_MESSAGE = "6자리 숫자가 아닙니다.";
    private static final String DUPLICATE_NUMBERS_MESSAGE = "중복된 숫자를 입력하셨습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException(SIX_NUMBER_MESSAGE);
        }
        if(numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
