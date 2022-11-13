package lotto.domain;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import java.util.EnumMap;
import java.util.Map;

public class GradingMachine {

    private final Lotto winnerLotto;
    private final int bonusNumber;

    public GradingMachine(Lotto winnerLotto, int bonusNumber) {
        validateContainBonusNumber(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = validateBonusBallRange(bonusNumber);
    }

    private int validateContainBonusNumber(Lotto winnerLotto, int bonusNumber) {
        if (!winnerLotto.getLotto().contains(bonusNumber)) {
            return bonusNumber;
        }
        throw new IllegalArgumentException();
    }

    private int validateBonusBallRange(int bonusNumber) {
        if (bonusNumber >= MIN_LOTTO_NUMBER && MAX_LOTTO_NUMBER >= bonusNumber) {
            return bonusNumber;
        }
        throw new IllegalArgumentException();
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
