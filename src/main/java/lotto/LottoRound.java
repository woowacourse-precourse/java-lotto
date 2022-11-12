package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoRound {

    private final Lotto winningLotto;
    private final Set<Integer> luckyNumbers;
    private final int bonusNumber;

    private LottoRound(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.luckyNumbers = new HashSet<>(winningLotto.getNumbers());
        validateBonusNumber();
    }

    public LottoRank getRank(Lotto selectedNumber) {
        int sameNumbers = getSameNumbers(selectedNumber);
        if (sameNumbers == 6) {
            return LottoRank.FIRST;
        }
        if (sameNumbers == 5) {
            if (haveBonusNumber(selectedNumber)) {
                return LottoRank.SECOND;
            }
            return LottoRank.THIRD;
        }
        if (sameNumbers == 4) {
            return LottoRank.FOURTH;
        }
        if (sameNumbers == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.LOSE;
    }

    private void validateBonusNumber() {
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(LottoRankingErrorMessages.INVALID_BONUS_NUMBER_RANGE.message);
        }

        if (luckyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoRankingErrorMessages.BONUS_NUMBER_DUPLICATED.message);
        }
    }
    
    private int getSameNumbers(Lotto selectedNumber) {
        int result = 0;
        for (int num : selectedNumber.getNumbers()) {
            if (luckyNumbers.contains(num)) {
                result++;
            }
        }
        return result;
    }

    private boolean haveBonusNumber(Lotto selectedNumber) {
        for (int num : selectedNumber.getNumbers()) {
            if (num == this.bonusNumber) {
                return true;
            }
        }
        return false;
    }

    enum LottoRankingErrorMessages {
        INVALID_BONUS_NUMBER_RANGE("보너스 숫자는 1 ~ 45 범위여야 합니다."),
        BONUS_NUMBER_DUPLICATED("보너스 숫자와 중복되는 당첨번호가 존재합니다.");

        private final String message;

        LottoRankingErrorMessages(String message) {
            this.message = message;
        }
    }

}
