package lotto.controller;

import lotto.domain.*;
import lotto.domain.lottoMachine.LottoMachine;
import lotto.ui.InputUI;
import lotto.ui.OutputUI;

import java.util.List;

public class LottoController {

    private static final InputUI inputUI = new InputUI();
    private static final OutputUI outputUI = new OutputUI();
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final RaffleMachine raffleMachine = new RaffleMachine();
    private static final RaffleStaticsCalculator raffleStaticCalculator = new RaffleStaticsCalculator();

    public void start() {
        List<Lotto> lottos = buyLottos();

        List<Integer> normalNumbers = inputUI.getNormalNumbers();
        Integer bonusNumbers = inputUI.getBonusNumbers(normalNumbers);

        List<Integer> resultOfLottos = raffleMachine.getResultOfLottos(lottos, normalNumbers, bonusNumbers);
        double returnRate = raffleStaticCalculator.calculateStatics(resultOfLottos, lottos.size());

        ResultLotto resultLotto = createResultLotto(resultOfLottos);
        outputUI.printWinnerResult(resultLotto);
        outputUI.printReturnRate(returnRate);


    }

    private ResultLotto createResultLotto(List<Integer> resultOfLottos) {
        ResultLotto resultLotto = new ResultLotto(resultOfLottos);
        return resultLotto;
    }

    private List<Lotto> buyLottos() {
        int money = inputUI.getMoney();
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(money);
        outputUI.printLottos(lottos);
        return lottos;
    }
}
