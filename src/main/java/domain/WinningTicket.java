package domain;

import lotto.Lotto;

import java.util.List;

public class WinningTicket extends Lotto {
    private static final String WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다";
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningTicket(List<Integer> winningTicket, int bonusNumber) {
        super(winningTicket);
        validateDuplicateNumber(winningTicket, bonusNumber);
        this.winningNumbers = new Lotto(winningTicket);
        this.bonusNumber = bonusNumber;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkContains(bonusNumber);
    }

    private void validateDuplicateNumber(List<Integer> winningTicket, int bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR);
        }
    }


}
