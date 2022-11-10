package lotto;

import java.util.List;

public class Answer {

    private final Lotto answer;
    private final int bonusNumber;

    public Answer(List<Integer> answers, int bonusNumber) {
        this.answer = new Lotto(answers);
        this.bonusNumber = bonusNumber;
    }

    public GameResult play(Lotto lotto) {
        int count = answer.countContainsNumber(lotto);
        boolean hasBonus = lotto.isContains(bonusNumber);
        return GameResult.of(count, hasBonus);
    }
}
