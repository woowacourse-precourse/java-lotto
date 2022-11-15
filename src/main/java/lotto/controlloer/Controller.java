package lotto.controlloer;

import static lotto.view.SystemMessage.YIELD_MESSAGE;
import static lotto.view.InputView.*;
import static lotto.view.outputView.printLottoGroup;
import static lotto.view.outputView.printWinningMessage;

import java.util.Map;
import lotto.domain.AnswerLotto;
import lotto.domain.Buyer;
import lotto.domain.LottoGroup;
import lotto.domain.NumberGenerator;
import lotto.domain.WinningRank;
import lotto.domain.WinningStatistics;
import lotto.view.outputView;

public class Controller {

    public boolean run(){
        try {
            Buyer buy = new Buyer(inputMoney());
            LottoGroup lottoGroup = buyLotto(buy);
            AnswerLotto answerLotto = new AnswerLotto(getLottoAnswerNumber(), inputBonusNumber());
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(
                    lottoGroup, answerLotto);
            printWinningMessage();
            printWinningInformation(winningDetails);
            calculateStatistic(winningDetails, buy.getMoney());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private LottoGroup buyLotto(Buyer buy){
        NumberGenerator lottogenerator = new NumberGenerator();
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(buy.getNumOfLotto()));
        printLottoGroup(lottoGroup, buy.getNumOfLotto());
        return lottoGroup;
    }


    private void printWinningInformation(Map<WinningRank, Integer> winningDetails) {
        outputView.printWinningDetails(winningDetails);
     }

     private void calculateStatistic(Map<WinningRank, Integer> winningDetails, Integer money){
         long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
         printYield(WinningStatistics.getLottoYield(winningAmount, money));
     }

    public static void printYield(double lottoYield) {
        System.out.printf(YIELD_MESSAGE, lottoYield);
    }
}
