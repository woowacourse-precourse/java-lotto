package lotto.model;

import static lotto.utils.NumberAdapter.fitBonusNumber;
import static lotto.utils.NumberAdapter.fitWinningNumber;
import static lotto.utils.NumberAdapter.fitWinningNumberWithBonusNumber;
import static lotto.utils.NumberAdapter.getPaidMoney;
import static lotto.validator.BonusNumberValidator.hasValidBonusNumber;
import static lotto.validator.LottoNumberValidator.hasValidLotteryNumber;
import static lotto.view.InputView.readBonusNumber;
import static lotto.view.InputView.readUserPaidMoney;
import static lotto.view.InputView.readWinningNumber;

import java.util.List;

public class Store {
    private Customer customer;
    private List<Integer> winningNumberWithBonusNumber;

    public Store() {
    }

    public void sellLottoToCustomer() {
        int paidMoney = getPaidMoney(readUserPaidMoney());
        this.customer = new Customer(paidMoney);
    }

    public void pickWinningNumberWithBonusNumber() {
        List<Integer> winningNumber = pickWinningNumber();
        int bonusNumber = pickBonusNumber(winningNumber);
        this.winningNumberWithBonusNumber = fitWinningNumberWithBonusNumber(winningNumber, bonusNumber);
    }

    private List<Integer> pickWinningNumber() {
        List<Integer> winningNumber = fitWinningNumber(readWinningNumber());
        hasValidLotteryNumber(winningNumber);
        return winningNumber;
    }

    private int pickBonusNumber(List<Integer> winningNumber) {
        int bonusNumber = fitBonusNumber(readBonusNumber());
        hasValidBonusNumber(winningNumber, bonusNumber);
        return bonusNumber;
    }
}
