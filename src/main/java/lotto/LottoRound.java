package lotto;

import config.ErrorConstants;

import java.util.HashSet;
import java.util.Set;

public class LottoRound {

    private final Lotto winningLotto;
    private final Set<Integer> luckyNumbers;
    private final int bonusNumber;

    /**
     * 하나의 로또 회차를 생성합니다.
     * 로또 회차에 해당하는 로또 번호들을 비교하여 순위를 얻을 수 있도록 제공합니다.
     * @param winningLotto 당첨 번호
     * @param bonusNumber 보너스 번호
     */
    public LottoRound(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.luckyNumbers = new HashSet<>(winningLotto.getNumbers());
        validateBonusNumber();
    }

    /**
     * 해당 회차의 당첨 번호와 구입한 로또 번호를 비교하여 순위 정보를 반환합니다.
     * @param selectedNumber 구입한 로또 번호
     * @return 당첨된 순위 정보
     */
    public LottoRank getRank(Lotto selectedNumber) {
        int sameNumbers = getSameNumbers(selectedNumber);
        if (sameNumbers == 6)
            return LottoRank.FIRST;
        if (sameNumbers == 5) {
            if (haveBonusNumber(selectedNumber))
                return LottoRank.SECOND;
            return LottoRank.THIRD;
        }
        if (sameNumbers == 4)
            return LottoRank.FOURTH;
        if (sameNumbers == 3)
            return LottoRank.FIFTH;
        return LottoRank.LOSE;
    }

    /**
     * 보너스 번호에 대해 검증합니다.
     * 보너스 번호는 1 ~ 45 범위의 정수이며, 당첨 번호와 중복될 수 없습니다.
     * @throws IllegalArgumentException 보너스 번호가 1 ~ 45 범위를 벗어나거나, 당첨 번호와 중복되는 경우 예외 발생
     */
    private void validateBonusNumber() throws IllegalArgumentException {
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_BONUS_NUMBER_RANGE);
        }

        if (luckyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorConstants.BONUS_NUMBER_DUPLICATED);
        }
    }

    /**
     * 당첨 번호와 비교하여 일치하는 번호의 수를 반환합니다.
     * @param selectedNumber 구입한 로또 번호
     * @return 일치하는 번호의 수
     */
    private int getSameNumbers(Lotto selectedNumber) {
        int result = 0;
        for (int num : selectedNumber.getNumbers()) {
            if (luckyNumbers.contains(num)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 보너스 번호가 포함된 번호인지 반환합니다.
     * @param selectedNumber 구입한 로또 번호
     * @return 보너스 번호 포함 여부
     */
    private boolean haveBonusNumber(Lotto selectedNumber) {
        for (int num : selectedNumber.getNumbers()) {
            if (num == this.bonusNumber) {
                return true;
            }
        }
        return false;
    }

}
