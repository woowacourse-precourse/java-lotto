package lotto.model;

import static lotto.constants.LottoConstant.BONUS_NUMBER_INDEX;
import static lotto.utils.Calculator.calculateCountsByRanks;
import static lotto.utils.NumberAdapter.fitBonusNumber;
import static lotto.utils.NumberAdapter.fitPaidMoney;
import static lotto.utils.NumberAdapter.fitWinningNumber;
import static lotto.utils.NumberAdapter.fitWinningNumberWithBonusNumber;
import static lotto.validator.BonusNumberValidator.hasValidBonusNumber;
import static lotto.validator.LottoNumberValidator.hasValidLottoNumber;

import java.util.List;
import java.util.Map;

public class Store {
    private Customer customer;
    private List<Integer> winningNumberWithBonusNumber;

    public Store() {
    }

    public void sellLottoToCustomer(String beforePaidMoney) {
        int paidMoney = fitPaidMoney(beforePaidMoney);
        this.customer = new Customer(paidMoney);
    }

    public void pickWinningNumberWithBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumberWithBonusNumber = fitWinningNumberWithBonusNumber(winningNumber, bonusNumber);
    }

    public List<Integer> pickWinningNumber(String beforeWinningNumber) {
        List<Integer> winningNumber = fitWinningNumber(beforeWinningNumber);
        hasValidLottoNumber(winningNumber);
        return winningNumber;
    }

    public int pickBonusNumber(List<Integer> winningNumber, String beforeBonusNumber) {
        int bonusNumber = fitBonusNumber(beforeBonusNumber);
        hasValidBonusNumber(winningNumber, bonusNumber);
        return bonusNumber;
    }

    public Map<Rank, Integer> judgeCustomerRanks() {
        List<Integer> winningNumber = winningNumberWithBonusNumber.subList(0, BONUS_NUMBER_INDEX);
        int bonusNumber = winningNumberWithBonusNumber.get(BONUS_NUMBER_INDEX);

        return calculateCountsByRanks(customer.judgeLottoRanks(winningNumber, bonusNumber));
    }

    public String getAllLottoByCustomer() {
        return customer.getAllLottoToString();
    }

    public float getRateOfProfitByCustomer(Map<Rank, Integer> customerRanks) {
        return customer.getRateOfProfit(customerRanks);
    }
}
