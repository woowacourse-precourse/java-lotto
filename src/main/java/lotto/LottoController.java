package lotto;

import lotto.UI.InputUI;
import lotto.UI.OutputUI;

import java.util.List;

public class LottoController {

    private static final InputUI inputUI = new InputUI();
    private static final OutputUI outputUI = new OutputUI();
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final RaffleCounter raffleCounter = new RaffleCounter();
    private static final RaffleStaticsCalculator raffleStaticCalculator = new RaffleStaticsCalculator();

    public void start() {
        int money = inputUI.getMoney();
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(money);
        outputUI.printLottos(lottos);

        List<Integer> normalNumbers = inputUI.getNormalNumbers();
        Integer bonusNumbers = inputUI.getBonusNumbers();
        List<Integer> lottoResults = List.of(0, 0, 0, 0, 0, 0);
        for (Lotto lotto : lottos) {
            // 일반 번호, 보너스 번호 몇개 포함되었는지 리스트
            // TODO: 데이터 교환 형식 재정의 필요
            Integer rank = raffleCounter.countWinner(lotto, normalNumbers, bonusNumbers);
            lottoResults.add(rank, 1);
        }

        double returnRate = raffleStaticCalculator.calculateStatics(lottoResults, lottos.size());

        outputUI.printWinnerCounts(lottoResults, returnRate);


    }
}
