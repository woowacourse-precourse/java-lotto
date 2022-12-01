package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.util.LottoRandomPeek;
import lotto.util.Statistics;

import static lotto.view.OutputView.*;

public class LottoService {
    private final InputView inputView = new InputView();
    private final Statistics statistics = new Statistics();
    private final LottoRandomPeek lottoRandomPeek = new LottoRandomPeek();
    public void play() throws IllegalArgumentException {

        Buyer buyer = inputView.makeBuyer();
        lottoRandomPeek.generateRandom(buyer.getBuyLottoCount());
        printObjectState(lottoRandomPeek.toString());
        WinLotto winLotto = inputView.makeWinLotto();
        statistics.compareNumber(lottoRandomPeek.getRandomLottos(), winLotto);
        statistics.calculateProfitRate(buyer);
        printObjectState(statistics.toString());

    }
}
