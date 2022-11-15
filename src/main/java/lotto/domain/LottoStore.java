package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lotto.ui.InformationMessage;

public class LottoStore {
    public LottoStore() {
    }

    public void visit() {
        InformationMessage msg = new InformationMessage();
        msg.printBeforeBuyMessage();
        User user1 = new User();
        user1.payMoney();
        user1.buyLotto();
        msg.printAfterBuyMessage(user1.getLottoCnt());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < user1.getLottoCnt(); i++) {
            NumberGenerator ng = new NumberGenerator(1, 45, 6);
            Lotto lotto = new Lotto(ng.getNumbers());
            lotto.getNumbers().sort(Comparator.naturalOrder());
            msg.printLottoNumber(lotto.getNumbers());
            lottos.add(lotto);
        }
        NumberGenerator ng = new NumberGenerator();
        msg.printBeforeWinningNumberInputMessage();
        ng.setWinningNumber();
        msg.printBeforeBonusNumberInputMessage();
        ng.setBonusNumber();
        msg.printBeforeResultMessage();
        int[] result = { 0, 0, 0, 0, 0 };
        int sum = 0;
        for (int i = 0; i < lottos.size(); i++) {
            Calculator calculator = new Calculator(lottos.get(i), ng);
            calculator.compareNumber();
            result[(calculator.getRank() + 5) % 5]++;
            sum += calculator.getReward();
        }
        msg.printResult(result);
        double profitPercent = Math.round((sum / user1.getLottoCnt()) * 100) / 100.0;
        msg.printTotalRewardPercent(profitPercent);
    }
}
