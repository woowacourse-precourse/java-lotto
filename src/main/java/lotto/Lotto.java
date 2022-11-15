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
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getMessage());
        }
        for (Integer number:numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMessage());
            }
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
