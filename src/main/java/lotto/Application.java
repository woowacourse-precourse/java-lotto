package lotto;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Model;
import lotto.model.Money;
import lotto.view.View;

import java.util.HashMap;
import java.util.List;

public class Application {

    private List<List<Integer>> LOTTOS;
    private HashMap<Integer, Integer> PRIZE_RANKINGS;

    public static void main(String[] args) {
        checkLotto();
    }
    public static void checkLotto () {
        Application app = new Application();
        View view = new View();

        Model model = new Model();
        Money money = new Money(view.inputMoney());
        app.LOTTOS = model.getUsersLottos(money.getMoney());

        view.printUncheckedLotto(app.LOTTOS);

        Lotto lotto = new Lotto(view.inputLottoNumber());
        Bonus bonus = new Bonus(view.inputBonusNumber(), lotto.getLottoNumbers());
        app.PRIZE_RANKINGS = model.checkPrize(money.getMoney(), bonus.getBonus(), lotto.getLottoNumbers());

        view.printResult(app.PRIZE_RANKINGS, model.getRateOfProfit());
    }
}
