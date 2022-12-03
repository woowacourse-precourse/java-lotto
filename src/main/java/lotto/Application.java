package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStats;
import lotto.domain.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    public static void main(String[] args) {
        try {
            programStart();
            Integer cost = inputView.inputCost();
            Purchase purchase = new Purchase();
            purchase.lotto(cost);

            OutputView.purchaseLottoResultPrint(purchase.getMyLotto());

            Lotto winningNumber = inputView.inputWinningNumber();
            Integer bonus = inputView.inputBonusNumber(winningNumber);

            LottoStats lottoStats = new LottoStats();
            lottoStats.calculationStats(purchase, winningNumber, bonus);

            OutputView.StatsResultPrint(lottoStats.statistics(), lottoStats.getEarning());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
    public static void programStart(){
        System.out.print("구입금액을 입력해주세요.");
    }
}
