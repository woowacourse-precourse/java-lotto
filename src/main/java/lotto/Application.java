package lotto;

import lotto.Model.Lotto;
import lotto.Model.User;
import lotto.Model.WinningLotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningCount;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        int price = view.askPrice();

        LottoGenerator lottoGenerator = new LottoGenerator();
        User userLotto = new User(lottoGenerator.generateLottoBundle(price));
        view.buyLottoList(price, userLotto.getUserLotto());

        List<Integer> winningNumber = view.askWinningNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumber), view.askBonusNumber());

        LottoChecker lottoChecker = new LottoChecker();
        WinningCount winningCount = new WinningCount();
        for (Lotto lotto : userLotto.getUserLotto()) {
            int lottoResult = lottoChecker.lottoCompare(lotto, winningLotto);
            winningCount.addWinningResult(Integer.toString(lottoResult),lottoChecker.bonusCompare(lotto,winningLotto));
        }

        view.showWinCase(winningCount);
        view.showProfitRate(lottoChecker.profitRate(price,winningCount.getProfitSum()));
    }
}
