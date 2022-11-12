package lotto.model;

import static lotto.utils.NumberAdapter.getPaidMoney;
import static lotto.view.InputView.readUserPaidMoney;

import java.util.List;

public class Store {
    private final Customer customer;
    private final List<Integer> winningNumber;

    public Store(
            Customer customer,
            List<Integer> winningNumber) {
        this.customer = customer;
        this.winningNumber = winningNumber;
    }

    public void sellLottoToCustomer() {
        int paidMoney = getPaidMoney(readUserPaidMoney());
        new Customer(paidMoney);
    }
}
