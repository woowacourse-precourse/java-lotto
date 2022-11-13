package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBER_RANGE_EXCEPTION;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import java.util.EnumMap;
import java.util.Map;
import lotto.view.Output;

public class GradingMachine {

    private static final String BONUS_NUMBER_CONTAIN_EXCEPTION = "보너스 번호는 당첨번호와 중복될 수 없습니다.";
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
        Output.printExceptionMessage(BONUS_NUMBER_CONTAIN_EXCEPTION);
        throw new IllegalArgumentException();
    }

    private int validateBonusBallRange(int bonusNumber) {
        if (bonusNumber >= MIN_LOTTO_NUMBER && MAX_LOTTO_NUMBER >= bonusNumber) {
            return bonusNumber;
        }
        Output.printExceptionMessage(LOTTO_NUMBER_RANGE_EXCEPTION);
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
