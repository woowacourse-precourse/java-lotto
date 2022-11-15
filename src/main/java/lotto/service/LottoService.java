package lotto.service;

import lotto.domain.Validator;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.BuyLotto;
import lotto.domain.Statistic;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private final BuyLotto buyLotto;
    private final Validator validator;
    private final Statistic statistic;

    public LottoService() {
        buyLotto = new BuyLotto();
        validator = new Validator();
        statistic = new Statistic();
    }

    public void lottery() {
        int price = Buyer.getIntPrice(InputView.getPrice());
        int quantity = Buyer.getQuantity(price);
        buyLotto.createLottos(quantity);
        OutputView.printQuantity(quantity, buyLotto.getLottos());

        List<Integer> winNum = validator.inputNumber(InputView.getWinNum());
        int bonus = validator.stringToInt(InputView.getBonusNum());
        validator.validateNumRange(bonus);
        runStatistic(winNum, buyLotto.getLottos(), bonus, price);
    }


    private void runStatistic(List<Integer> winNum, List<Lotto> lottos, int bonus, int price) {
        statistic.countCorrect(winNum, lottos, bonus);
        OutputView.printStatistic(statistic.getCorrect(), statistic.getRevenue(price));
    }

}
