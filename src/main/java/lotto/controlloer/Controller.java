package lotto.controlloer;

import static lotto.domain.SystemMessage.DUPLICATE_BONUS_ERROR_MESSAGE;
import static lotto.domain.SystemMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.domain.SystemMessage.END_PROGRAM_MESSAGE;
import static lotto.domain.SystemMessage.ERROR_MESSAGE;
import static lotto.domain.SystemMessage.YIELD_MESSAGE;
import static lotto.view.InputView.*;
import static lotto.view.outputView.printLottoGroup;
import static lotto.view.outputView.printWinningMessage;

import java.util.List;
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
            printWinningMessage();
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
        Integer numOfLotto = getNumberOfLotto(money);
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(numOfLotto));
        printLottoGroup(lottoGroup, numOfLotto);
        return lottoGroup;
    }

    private AnswerLotto getAnswerLotto(){
        AnswerLotto answerLotto = new AnswerLotto(getLottoAnswerNumber(), inputBonusNumber());
        validateDuplicateBonusNumber(answerLotto.getAnswerLotto(), answerLotto.getBonusNumber());
        return answerLotto;
    }

    private static void validateDuplicateBonusNumber( List<Integer> lottos, Integer bonus) {
        if(lottos.contains(bonus))
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_BONUS_ERROR_MESSAGE);
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
