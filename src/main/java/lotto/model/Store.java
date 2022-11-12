package lotto.model;

import static lotto.utils.NumberAdapter.getPaidMoney;
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
}
