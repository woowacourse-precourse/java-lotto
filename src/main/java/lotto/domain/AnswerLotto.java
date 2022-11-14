package lotto.domain;

import java.util.List;

public class AnswerLotto {
    private final List<Integer> answerLotto;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.answerLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerLotto() {
        return answerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
