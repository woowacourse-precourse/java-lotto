package lotto.controller;
import lotto.model.customer.Customer;
import lotto.model.lotto.LottoDispenser;
import lotto.model.lotto.LottoResult;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(){
        lottoView = new LottoView();
    }

    public void run(){
        int money = lottoView.enterMoneyFromCustomer();
        Customer customer = new Customer(money);
        customer = LottoDispenser.purchase(customer, money);
        lottoView.printPurchasedLottos(customer);

        List<Integer> winNumbers = lottoView.enterWinNumbersFromAdmin();
        int bonusNumber = lottoView.enterBonusNumberFromAdmin(winNumbers);

        LottoResult lottoResult = new LottoResult();
        lottoResult.create(winNumbers, bonusNumber, customer);

        lottoView.printStat(lottoResult);
    }
}
