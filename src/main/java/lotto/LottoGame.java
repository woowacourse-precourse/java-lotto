package lotto;

import java.util.*;

public class LottoGame {

    private LottoGameView lottoGameView;

    public void play(Customer customer) {
        int money = lottoGameView.inputMoney();
        List<Lotto> lottos = customer.generateLottos(money);
        lottoGameView.printLottos(lottos);
        WinningNumber winningNumber = new WinningNumber(lottoGameView.inputWinningNumbers(), lottoGameView.inputBonusNumber());
        List<LottoRank> ranks = winningNumber.getRanks(lottos);
        lottoGameView.printWinningResult(ranks);
        lottoGameView.printRateOfReturn(winningNumber.getRateOfReturn(money, winningNumber.getTotalPrizeMoney(ranks)));
    }
}
