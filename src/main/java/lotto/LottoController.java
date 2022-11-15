package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void run(){
        View view = new View();

        int money = view.enterMoneyFromCustomer();

        LottoDispenser lottoDispenser = new LottoDispenser();

        Customer customer = new Customer(money);
        customer = lottoDispenser.purchase(customer, money);

        view.printPurchasedLottos(customer);

        List<Integer> winNumbers = view.enterWinNumbersFromAdmin();
        int bonusNumber = view.enterBonusNumberFromAdmin(winNumbers);

        //당첨시키기
        LottoResult lottoResult = new LottoResult();
        lottoResult.create(winNumbers, bonusNumber, customer);

        view.printStat(lottoResult);
    }
}
