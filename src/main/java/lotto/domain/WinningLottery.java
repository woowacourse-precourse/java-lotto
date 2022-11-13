package lotto.domain;

public class WinningLottery {
    private final Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLottery(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public LottoResult getResult(Lotto other) {
        if (isFiveAndBonusCorrect(other)) {
            return LottoResult.FIVE_BONUS_CORRECT;
        }
        return LottoResult.from(lotto.getScore(other));
    }

    private boolean isFiveAndBonusCorrect(Lotto other) {
        if (lotto.getScore(other) != 5) {
            return false;
        }
        return other.contains(bonusNumber);
    }
}
