package lotto.controlloer;

import static lotto.domain.SystemMessage.YIELD_MESSAGE;
import static lotto.view.InputView.*;
import static lotto.view.outputView.printLottoGroup;

import java.util.Map;
import lotto.domain.AnswerLotto;
import lotto.domain.LottoGroup;
import lotto.domain.NumberGenerator;
import lotto.domain.WinningRank;
import lotto.domain.WinningStatistics;
import lotto.view.outputView;

public class Controller {

    public boolean run(){
        try {
            Integer money = inputMoney();
            LottoGroup lottoGroup = buyLotto(money);
            AnswerLotto answerLotto = getAnswerLotto();
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(
                    lottoGroup, answerLotto);
            printWinningInformation(winningDetails);
            calculateStatistic(winningDetails,money);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private LottoGroup buyLotto(Integer money){
        NumberGenerator lottogenerator = new NumberGenerator();
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(getNumberOfLotto(money)));
        printLottoGroup(lottoGroup, money);
        return lottoGroup;
    }

    private AnswerLotto getAnswerLotto(){
        AnswerLotto answerLotto = new AnswerLotto(getLottoAnswerNumber(), inputBonusNumber());
        return answerLotto;
    }

    private int getNumberOfLotto(int money){
        return money / 1000;
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
