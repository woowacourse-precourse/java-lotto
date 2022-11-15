package lotto;

import lotto.domain.*;
import lotto.view.View;

import java.util.HashMap;
import java.util.List;

public class Application {

    private List<List<Integer>> LOTTOS;
    private HashMap<Integer, Integer> PRIZE_RANKINGS;

    public static void main(String[] args) {
        try {
            checkLotto();
        }catch (Exception e) {
            // exit
        }
    }
    public static void checkLotto () {
        Application app = new Application();
        View view = new View();

        Model model = new Model();
        Money money = new Money(view.inputMoney());
        RandomLotto randomLotto = new RandomLotto(money.getMoney());
        app.LOTTOS = randomLotto.getLottos();

        view.printUncheckedLotto(app.LOTTOS);

        Lotto lotto = new Lotto(view.inputLottoNumber());
        Bonus bonus = new Bonus(view.inputBonusNumber(), lotto.getLottoNumbers());
        app.PRIZE_RANKINGS = model.checkPrize(money.getMoney(), bonus.getBonus(), lotto.getLottoNumbers(), app.LOTTOS);

        view.printResult(app.PRIZE_RANKINGS, model.getRateOfProfit());
    }
}
