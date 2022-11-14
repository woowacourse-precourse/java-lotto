package lotto.domain;

final class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public LottoResult getResult(Lotto other) {
        LottoSameCount lottoSameCount = LottoSameCount.from(lotto.getScore(other));
        LottoContainBonus lottoContainBonus = LottoContainBonus.from(other.contains(bonusNumber));
        return new LottoResult(lottoSameCount, lottoContainBonus);
    }
}
