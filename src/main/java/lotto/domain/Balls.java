package lotto.domain;

import constants.ExceptionMessage;
import lotto.domain.dto.MatchResultDTO;
import lotto.presentation.view.LottoExceptionPrinter;

public class Balls {

    private final WinningBalls winningBalls;
    private final BonusBall bonusBall;

    public Balls(WinningBalls winningBalls, BonusBall bonusBall) {
        validate(winningBalls, bonusBall);
        this.winningBalls = winningBalls;
        this.bonusBall = bonusBall;
    }

    private void validate(WinningBalls winningBalls, BonusBall bonusBall) {
        if (winningBalls.containsBonusNumber(bonusBall)) {
            LottoExceptionPrinter.throwContainBonus();
            throw new IllegalArgumentException(ExceptionMessage.CONTAIN_BONUS);
        }
    }

    public MatchResultDTO matching(Lotto lotto) {
        int matchCount = lotto.matchWinningBalls(winningBalls);
        boolean isMatchBonusBall = lotto.matchBonusBall(bonusBall);

        return new MatchResultDTO(matchCount, isMatchBonusBall);
    }

}
