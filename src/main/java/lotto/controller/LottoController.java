package lotto.controller;

import lotto.domain.lottoData.Lotto;
import lotto.domain.lottoData.TotalWinnerLotto;
import lotto.domain.lottoData.WinnerLotto;
import lotto.domain.lottoDevice.LottoMachine;
import lotto.domain.raffleDevice.RaffleMachine;
import lotto.domain.raffleDevice.RaffleResultCalculator;
import lotto.ui.InputUI;
import lotto.ui.OutputUI;

import java.util.List;

public class LottoController {

    private static final InputUI inputUI = new InputUI();
    private static final OutputUI outputUI = new OutputUI();
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final RaffleMachine raffleMachine = new RaffleMachine();
    private static final RaffleResultCalculator raffleResultCalculator = new RaffleResultCalculator();

    public void start() {
        List<Lotto> lottos = buyLottos();

        WinnerLotto winnerLotto = new WinnerLotto(inputUI.getLottoNumbers());

        TotalWinnerLotto totalWinnerLotto = new TotalWinnerLotto(raffleMachine.getWinnerPerRank(lottos, winnerLotto.getNormalNumbers(), winnerLotto.getBonusNumber()));
        outputUI.printWinnerPerRank(totalWinnerLotto.getWinnerPerRank());

        double returnRate = raffleResultCalculator.getProfitRate(totalWinnerLotto.getWinnerPerRank(), lottos.size());
        outputUI.printProfitRate(returnRate);
    }


    private List<Lotto> buyLottos() {
        int money = inputUI.getMoney();
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(money);
        outputUI.printLottos(lottos);
        return lottos;
    }
}
