package lotto;

import lotto.message.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Lotto_Numbers_Size));
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for(int i = 0; i < 6; i++) {
            if(numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(String.valueOf(ErrorMessage.Lotto_Numbers_Range));
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        if(!numbers.stream().distinct().equals(numbers)) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Lotto_Numbers_Duplicate));
        }
    }

    public List<Integer> lottoNumbers() {
        return numbers;
    }
}
