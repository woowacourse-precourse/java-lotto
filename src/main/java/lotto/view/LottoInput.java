package lotto.view;

import java.util.List;
import lotto.domain.Money;
import lotto.validator.LottoValidator;

public class LottoInput {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Money money;

    private LottoInput() {
    }

    public static LottoInput create(List<Integer> winningNumbers, int bonusNumber, Money money) {
        LottoInput lottoInput = new LottoInput();
        lottoInput.addWinningNumbers(winningNumbers);
        lottoInput.addBonusNumber(bonusNumber);
        lottoInput.addMoney(money);
        return lottoInput;
    }
    public void addWinningNumbers(List<Integer> winningNumbersInput) {
        LottoValidator.validateDuplicateNumber(winningNumbersInput);
        LottoValidator.validateLottoSize(winningNumbersInput);
        LottoValidator.validateNumberRange(winningNumbersInput);
        this.winningNumbers = winningNumbersInput;
    }

    public void addBonusNumber(int bonusNumber) {
        LottoValidator.validateDuplicateWinningAndBonusNumber(this.winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void addMoney(Money money) {
        LottoValidator.validateLottoMoney(money);
        this.money = money;
    }
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Money getMoney() {
        return money;
    }
}
