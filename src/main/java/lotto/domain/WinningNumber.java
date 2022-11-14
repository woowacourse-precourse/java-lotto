package lotto.domain;

import java.util.Objects;

public class WinningNumber {
    private static final String DUPLICATE_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(Lotto otherLottoNumbers) {
        int cnt = lotto.calculateSameCount(otherLottoNumbers);
        return Ranking.findRanking(cnt, otherLottoNumbers.getLottoNumbers().contains(bonusNumber));
    }

    private void validateDuplicateNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }
}