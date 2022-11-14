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
        // 로또 구매
        List<Lotto> lottos = buyLottos();

        // 로또 입력, normalNumbers, bonusNumbers 나옴 -> Lotto상속 받아서 구현하자.
        WinnerLotto winnerLotto = new WinnerLotto(inputUI.getLottoNumbers());

        // 로또 당첨 결과 반환, TotalWinnerLottos라고 하자.
        TotalWinnerLotto totalWinnerLotto = new TotalWinnerLotto(raffleMachine.getWinnerPerRank(lottos, winnerLotto.getNormalNumbers(), winnerLotto.getBonusNumber()));
        outputUI.printWinnerResult(totalWinnerLotto.getWinnerPerRank());

        // 로또 수익률 계산
        double returnRate = raffleResultCalculator.getProfitRate(totalWinnerLotto.getWinnerPerRank(), lottos.size());
        outputUI.printReturnRate(returnRate);
    }


    private List<Lotto> buyLottos() {
        int money = inputUI.getMoney();
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(money);
        outputUI.printLottos(lottos);
        return lottos;
    }
}
