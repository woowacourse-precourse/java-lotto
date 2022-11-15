package lotto;

import lotto.enums.EtcNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != EtcNumber.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
