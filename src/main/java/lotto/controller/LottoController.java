package lotto.controller;

import lotto.domain.lottoData.Lotto;
import lotto.domain.lottoData.TotalWinnerLotto;
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
    private static final RaffleResultCalculator raffleStaticCalculator = new RaffleResultCalculator();

    public void start() {
        // 로또 구매
        List<Lotto> lottos = buyLottos();

        // 로또 입력, normalNumbers, bonusNumbers 나옴 -> Lotto상속 받아서 구현하자.
        List<Integer> normalNumbers = inputUI.getNormalNumbers();
        Integer bonusNumbers = inputUI.getBonusNumber(normalNumbers);

        List<Integer> resultOfLottos = raffleMachine.getResultOfLottos(lottos, normalNumbers, bonusNumbers);
        double returnRate = raffleStaticCalculator.calculateStatics(resultOfLottos, lottos.size());

        TotalWinnerLotto totalWinnerLotto = createResultLotto(resultOfLottos);
        outputUI.printWinnerResult(totalWinnerLotto);
        outputUI.printReturnRate(returnRate);


    }

    private TotalWinnerLotto createResultLotto(List<Integer> resultOfLottos) {
        TotalWinnerLotto totalWinnerLotto = new TotalWinnerLotto(resultOfLottos);
        return totalWinnerLotto;
    }

    private List<Lotto> buyLottos() {
        int money = inputUI.getMoney();
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(money);
        outputUI.printLottos(lottos);
        return lottos;
    }
}
