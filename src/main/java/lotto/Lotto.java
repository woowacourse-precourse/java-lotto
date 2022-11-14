package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getErrorMsg());
        }
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public void validBonusNumber(Integer bonusNum) throws IllegalArgumentException {
        if (this.numbers.contains(bonusNum)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getErrorMsg());
        }
    }
}
