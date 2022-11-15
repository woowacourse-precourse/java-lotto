package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private static final String CONTAIN_BONUS_NUMBER_ERROR = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    public final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateContainBonusNumber();
        validateDuplicateNumber();
    }

    private void validateContainBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CONTAIN_BONUS_NUMBER_ERROR);
        }
    }

    private void validateDuplicateNumber() {
        HashSet<Integer> numbers = new HashSet<>(winningNumbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private int countHitNumber(Lotto lottoNumbers) {
        return (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public LottoRank calculateRank(Lotto lotto) {
        int hitCount = countHitNumber(lotto);
        boolean hasBonus = lotto.contains(bonusNumber);
        return LottoRank.valueOf(hitCount, hasBonus);
    }
}
