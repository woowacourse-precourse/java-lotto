package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public Run() {

        Checker checker = new Checker();
        Customer customer = new Customer();
        Store store = new Store();
        View view = new View();
        List<Lotto> lottos = new ArrayList<>();

        view.insertMoney();
        customer.payMoney();

        customer.buyLotto();
        view.showHasLotto(customer.getHasLotto());

        store.drawNumber(customer.getHasLotto());

        for (int i = 0; i < customer.getHasLotto(); i++) {
            lottos.add(new Lotto(store.getNumbers().get(i)));
            view.showLotto(lottos.get(i));
        }

        view.insertWinningNumber();
        checker.insertWinningNumbers();

        view.insertBonusNumber();
        checker.insertBonusNumber();

        for (int i = 0; i < customer.getHasLotto(); i++) {
            checker.checkMyLotto(lottos.get(i).getLotto());
        }

        checker.showWinningStats();
        checker.calculateRateOfReturn(customer.getMoney());
        view.showReturnRate(checker.getReturnRate());

    }
}
