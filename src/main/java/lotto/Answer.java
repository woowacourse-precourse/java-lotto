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
        int countResult = answer.countContainsNumber(lotto);
        return GameResult.of(countResult);
    }
}
