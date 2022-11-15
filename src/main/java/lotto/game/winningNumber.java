package lotto.game;
import lotto.validator.lottoValidator;
public class winningNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public winningNumber(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.lotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        lottoValidator.checkBonusNumber(lotto.getNumbers(), bonusNumber);
    }
}
