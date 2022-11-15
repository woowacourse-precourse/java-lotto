package lotto.controller;

import lotto.domain.*;
import lotto.view.InputConsole;
import lotto.view.OutputConsole;

import java.util.List;

public class GameController {
    private LottoIssuer lottoIssuer;
    private ResultGenerator resultGenerator;

    public GameController(LottoIssuer lottoIssuer, ResultGenerator resultGenerator) {
        this.lottoIssuer = lottoIssuer;
        this.resultGenerator = resultGenerator;
    }

    public void play() {
        int purchasePrice = InputConsole.askPurchasePrice();
        Lottos users = purchaseLottos(purchasePrice);
        PrizeLotto prize = createPrizeLotto();
        Results results = resultGenerator.createResults(users, prize);
        WinningStatistics statistics = new WinningStatistics(results, purchasePrice);
        OutputConsole.printWinningStatistics(statistics);
    }

    private Lottos purchaseLottos(int purchasePrice) {
        Lottos usersLottos = lottoIssuer.purchaseLottos(purchasePrice);
        OutputConsole.printOrderHistory(usersLottos.getLottos());
        return usersLottos;
    }

    private PrizeLotto createPrizeLotto() {
        return new PrizeLotto(getPrizeNumbers(), getBonusNumber());
    }

    private List<Integer> getPrizeNumbers() {
        return InputConsole.askPrizeLottoNumber();
    }

    private int getBonusNumber() {
        return InputConsole.askBonusNumber();
    }
}
