package lotto;

import static lotto.Config.LOTTO_LENGTH;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoLength(numbers);
        this.numbers = numbers;
    }

    private void checkExistedLotto(List<Integer> numbers){
    }

    private void checkLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeNumber(List<Integer> numbers) {
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
    }
}
