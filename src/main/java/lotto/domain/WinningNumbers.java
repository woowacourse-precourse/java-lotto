package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    public final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateDuplicateNumber();
    }

    private void validateDuplicateNumber() {
        if (winningNumbers.contains(bonusNumber)) {
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
