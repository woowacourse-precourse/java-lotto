package lotto;

import java.util.List;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String OUT_OF_RANGE_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isValidateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidateNumber(List<Integer> numbers){
        for(Integer num : numbers){
            if(num<1||num>45){
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
            }
        }
    }
}
