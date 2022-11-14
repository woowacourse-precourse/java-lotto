package lotto.controlloer;

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
            LottoGroup lottoGroup = buyLotto();
            AnswerLotto answerLotto = getAnswerLotto();
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(
                    lottoGroup, answerLotto);
            printWinningInformation(winningDetails);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private LottoGroup buyLotto(){
        NumberGenerator lottogenerator = new NumberGenerator();
        Integer NumberOfLotto = inputMoney();
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(getNumberOfLotto(NumberOfLotto)));
        printLottoGroup(lottoGroup, NumberOfLotto);
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
}
