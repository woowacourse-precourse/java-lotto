package lotto.domain;

final class WinningLotto {
    private static final String DUPLICATE_MESSAGE = "당첨 번호와 보너스 번호가 중복됩니다";
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public LottoResult calculateBonusAndSameCount(Lotto other) {
        final LottoSameCount lottoSameCount = LottoSameCount.from(lotto.calculateTotalSameCount(other));
        final LottoContainBonus lottoContainBonus = LottoContainBonus.from(other.contains(bonusNumber));
        return new LottoResult(lottoSameCount, lottoContainBonus);
    }
}
