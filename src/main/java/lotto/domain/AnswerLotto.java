package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public AnswerLotto(List<Integer> numbers, Integer bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.lotto.validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public boolean contains(Integer number) {
        return this.lotto.contains(number);
    }
}
