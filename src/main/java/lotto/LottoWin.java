package lotto;

import java.util.List;

public class LottoWin extends Lotto {
    private final Integer bounsNumber;

    public LottoWin(List<Integer> numbers, Integer bounsNumber) {
        super(numbers);
        validate(numbers);
        this.bounsNumber = bounsNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("입력한 값이 " + LottoEnum.SIZE + "자리보다 작거나 큽니다!");
        }
    }
}
