package lotto.domain;

import lotto.LottoString;
import lotto.global.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_MAKER_ERROR);
        }
        for(Integer num : numbers){
            if(num < 0 || num > 45)
                throw new IllegalArgumentException(ErrorMessage.NUMBER_MAKER_ERROR);
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}
