package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class GradingMachine {

    private final Lotto winnerLotto;
    private final int bonusNumber;

    public GradingMachine(Lotto winnerLotto, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public GradesResult getGradesResultByLottoTicket(LottoTicket lottoTicket) {
        Map<Grade, Integer> gradeResult = new EnumMap<>(Grade.class);
        for (Lotto buyingLotto : lottoTicket.getLottoTicket()) {
            Grade grade = findGrade(buyingLotto);
            gradeResult.put(grade, gradeResult.getOrDefault(grade, 0) + 1);
        }
        return new GradesResult(gradeResult);
    }

    private Grade findGrade(Lotto buyingLotto) {
        return Grade.of(winnerLotto.getHitCount(buyingLotto), buyingLotto.hasBonusNumber(bonusNumber));
    }


}
