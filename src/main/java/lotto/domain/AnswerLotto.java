package lotto.domain;

import java.util.List;

public class AnswerLotto {
    private final List<Integer> answerLotto;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerLotto() {
        return answerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
