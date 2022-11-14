package domain;

import lotto.Lotto;

import java.util.List;

public class WinningTicket extends Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String WINNING_NUMBER_AND_BONUS_DUPLICATED_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningTicket(List<Integer> winningTicket, int bonusNumber) {
        super(winningTicket);
        validateDuplicateNumber(winningTicket, bonusNumber);
        this.winningNumbers = new Lotto(winningTicket);
        validateBonusNumber(bonusNumber);
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

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
