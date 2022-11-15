package lotto;

public class WinLotto {
    private Lotto lotto;
    private long bonusNumber;

    public WinLotto(Lotto lotto, long bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, long bonusNumber) {
        if (lotto.isExistInNumbers(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Rank getLottoResult(Lotto userLotto) {
        long winLottoCount = lotto.getWinLottoCount(userLotto);

        long bonusCount = 0;
        if (userLotto.isExistInNumbers(bonusNumber)) {
            bonusCount++;
        }

        if (winLottoCount == 5 && bonusCount == 1) {
            return Rank.SECOND;
        }

        return Rank.valueOfLottoCount(winLottoCount);
    }
}
