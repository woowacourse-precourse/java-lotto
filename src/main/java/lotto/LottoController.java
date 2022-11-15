package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoController {

    public void run(){
        View view = new View();

        int money = view.enterMoneyFromCustomer();

        LottoDispenser lottoDispenser = new LottoDispenser();

        Customer customer = new Customer(money);
        customer = lottoDispenser.purchase(customer, money);

        view.printPurchasedLottos(customer);

        List<Integer> winNumbers = view.enterWinNumbersFromAdmin();
        int bonousNumber = view.enterBonusNumberFromAdmin(winNumbers);

        //당첨시키기

        view.printStat();
    }
}
