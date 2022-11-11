package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {

    public static final int CRITERION_CAN_HAS_BONUS = 5;
    public static final int CRITERION_ZERO = 0;

    private final Lotto answer;
    private final int bonusNumber;

    public Answer(List<Integer> answers, int bonusNumber) {
        this.answer = new Lotto(answers);
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> play(Lottos lottos) {
        return IntStream.range(CRITERION_ZERO, lottos.size())
                .mapToObj(lottos::get)
                .map(this::play)
                .collect(Collectors.toList());
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
}
