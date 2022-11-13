package lotto.model;

import static lotto.constants.LottoConstant.BONUS_NUMBER_INDEX;
import static lotto.utils.Calculator.calculateCountsByRanks;
import static lotto.utils.NumberAdapter.fitBonusNumber;
import static lotto.utils.NumberAdapter.fitWinningNumber;
import static lotto.utils.NumberAdapter.fitWinningNumberWithBonusNumber;
import static lotto.utils.NumberAdapter.getPaidMoney;
import static lotto.validator.BonusNumberValidator.hasValidBonusNumber;
import static lotto.validator.LottoNumberValidator.hasValidLotteryNumber;

import java.util.List;
import java.util.Map;

public class Store {
    private Customer customer;
    private List<Integer> winningNumberWithBonusNumber;

    public Store() {
    }

    public void sellLottoToCustomer(String beforePaidMoney) {
        int paidMoney = getPaidMoney(beforePaidMoney);
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

    public Map<Rank, Integer> judgeCustomerRanks() {
        List<Integer> winningNumber = winningNumberWithBonusNumber.subList(0, BONUS_NUMBER_INDEX);
        int bonusNumber = winningNumberWithBonusNumber.get(BONUS_NUMBER_INDEX);

        return calculateCountsByRanks(customer.judgeLottoRanks(winningNumber, bonusNumber));
    }
}
