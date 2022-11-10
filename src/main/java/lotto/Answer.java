package lotto;

import java.util.List;

public class Answer {

    public static final int CRITERION_CAN_HAS_BONUS = 5;
    private final Lotto answer;
    private final int bonusNumber;

    public Answer(List<Integer> answers, int bonusNumber) {
        this.answer = new Lotto(answers);
        this.bonusNumber = bonusNumber;
    }

    public GameResult play(Lotto lotto) {
        int countResult = answer.countContainsNumber(lotto);
        boolean bonusResult = calculateBonus(lotto, countResult);
        return GameResult.of(countResult, bonusResult);
    }

    private boolean calculateBonus(Lotto lotto, int countResult) {
        return canHasBonus(countResult) && (lotto.isContains(bonusNumber));
    }

    private boolean canHasBonus(int countResult) {
        return countResult == CRITERION_CAN_HAS_BONUS;
    }
}
