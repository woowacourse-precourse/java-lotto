package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Answer {

    public static final int CRITERION_CAN_HAS_BONUS = 5;
    private final Lotto answer;
    private final int bonusNumber;

    public Answer(List<Integer> answers, int bonusNumber) {
        this.answer = new Lotto(answers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult play(Lotto lotto) {
        int countResult = answer.countContainsNumber(lotto);
        boolean bonusResult = calculateBonus(lotto, countResult);
        return LottoResult.of(countResult, bonusResult);
    }

    private boolean calculateBonus(Lotto lotto, int countResult) {
        return canHasBonus(countResult) && (lotto.isContains(bonusNumber));
    }

    private boolean canHasBonus(int countResult) {
        return countResult == CRITERION_CAN_HAS_BONUS;
    }

    public List<LottoResult> play(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::play)
                .collect(Collectors.toList());
    }

}
