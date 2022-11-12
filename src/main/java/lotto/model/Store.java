package lotto.model;

import static lotto.utils.NumberAdapter.fitBonusNumber;
import static lotto.utils.NumberAdapter.fitWinningNumber;
import static lotto.utils.NumberAdapter.fitWinningNumberWithBonusNumber;
import static lotto.utils.NumberAdapter.getPaidMoney;
import static lotto.validator.BonusNumberValidator.hasValidBonusNumber;
import static lotto.validator.LottoNumberValidator.hasValidLotteryNumber;
import static lotto.view.InputView.readUserPaidMoney;

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

    public void pickWinningNumberWithBonusNumber(String beforeWinningNumber, String beforeBonusNumber) {
        List<Integer> winningNumber = pickWinningNumber(beforeWinningNumber);
        int bonusNumber = pickBonusNumber(winningNumber, beforeBonusNumber);
        this.winningNumberWithBonusNumber = fitWinningNumberWithBonusNumber(winningNumber, bonusNumber);
    }

    private List<Integer> pickWinningNumber(String beforeWinningNumber) {
        List<Integer> winningNumber = fitWinningNumber(beforeWinningNumber);
        hasValidLotteryNumber(winningNumber);
        return winningNumber;
    }

    private int pickBonusNumber(List<Integer> winningNumber, String beforeBonusNumber) {
        int bonusNumber = fitBonusNumber(beforeBonusNumber);
        hasValidBonusNumber(winningNumber, bonusNumber);
        return bonusNumber;
    }
}
