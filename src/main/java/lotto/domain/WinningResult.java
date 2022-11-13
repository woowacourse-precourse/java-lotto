package lotto.domain;

public class WinningResult {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningResult(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateHasBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank check(Lotto issuedLotto) {
        int sameNumbersCount = issuedLotto.countSameNumbers(winningNumbers);
        boolean hasBonusNumber = issuedLotto.hasNumber(bonusNumber);
        return Rank.findRank(sameNumbersCount, hasBonusNumber);
    }

    private void validateHasBonusNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }
}
