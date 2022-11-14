package lotto;

import java.util.List;
import static lotto.Application.throwException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6){
            String message = "[ERROR] 로또 번호는 총 6개의 숫자이여야 합니다.";
            throwException(message);
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
