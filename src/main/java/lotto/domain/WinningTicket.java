package lotto.domain;

import java.util.List;

public class WinningTicket extends Lotto {
    private static final String WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final int bonusNumber;

    public WinningTicket(List<Integer> winningTicket, int bonusNumber) {
        super(winningTicket);
        if (this.checkContains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR);
        }
        this.validateLottoRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkContains(bonusNumber);
    }
}
