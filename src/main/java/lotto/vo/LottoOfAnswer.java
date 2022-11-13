package lotto.vo;

import java.util.List;

public class LottoOfAnswer extends Lotto {
    private final int bonusNumber;

    public LottoOfAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
