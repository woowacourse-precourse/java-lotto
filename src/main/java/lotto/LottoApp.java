package lotto;

import lotto.model.Lottos;
import lotto.model.WinningLotto;

import java.util.List;

public class LottoApp {
    public LottoService lottoService = new LottoService();
    public LottoController controller = new LottoController();
    public void run() {
        try {
            int money = controller.printAndRequestMoney();
            int buyingCount = controller.calAndShowBuyingCount(money);
            Lottos lottos = controller.getAndShowLotto(buyingCount);
            WinningLotto winningLotto = controller.getWinningLotto();
            List<Integer> result = controller.getAndShowLottoResult(winningLotto, lottos);
            controller.calAndShowRateOfReturn(money, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
