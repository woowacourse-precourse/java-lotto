package lotto;
import java.util.List;

public class LottoController {

    private final View view;

    public LottoController(){
        view = new View();
    }

    public void run(){
        int money = view.enterMoneyFromCustomer();
        Customer customer = new Customer(money);
        customer = LottoDispenser.purchase(customer, money);
        view.printPurchasedLottos(customer);

        List<Integer> winNumbers = view.enterWinNumbersFromAdmin();
        int bonusNumber = view.enterBonusNumberFromAdmin(winNumbers);

        LottoResult lottoResult = new LottoResult();
        lottoResult.create(winNumbers, bonusNumber, customer);

        view.printStat(lottoResult);
    }
}
