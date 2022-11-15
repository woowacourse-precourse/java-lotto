package lotto;

import java.util.List;

public class WinningTicket extends Lotto {
    private static final String WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다";

    private final int bonus;

    public WinningTicket(List<Integer> winningNumber, int bonus) {
        super(winningNumber);
        if (this.checkContains(bonus)) {
            throw new IllegalArgumentException(WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR);
        }
        this.checkLottoRange(bonus);
        this.bonus = bonus;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkContains(bonus);
    }
}
