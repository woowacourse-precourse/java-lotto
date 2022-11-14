package lotto.domain;


public class WinningNumbers {
    private static final String DUPLICATE_ERROR = "[ERROR]보너스 번호는 당첨 번호와 중복될 수 없습니다";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumbers(final Lotto lotto, final int bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    public LottoRank calculateRanking(Lotto otherLottoNumbers) {
        int cnt = lotto.calculateSameCount(otherLottoNumbers);
        return LottoRank.findRank(cnt, otherLottoNumbers.contains(bonusNumber));
    }

}
