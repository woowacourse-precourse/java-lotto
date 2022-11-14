package lotto.controlloer;

import static lotto.view.InputView.*;
import static lotto.view.outputView.printLottoGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.NumberGenerator;
import lotto.domain.WinningRank;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.outputView;

public class Controller {

    public void run(){
        LottoGroup lottoGroup = buyLotto();
        AnswerLotto answerLotto = getAnswerLotto();
        Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottoGroup, answerLotto);
        printWinningInformation(winningDetails);
    }

    private LottoGroup buyLotto(){
        NumberGenerator lottogenerator = new NumberGenerator();
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(getNumberOfLotto(inputMoney())));
        printLottoGroup(lottoGroup);
        return lottoGroup;
    }

    private AnswerLotto getAnswerLotto(){
        AnswerLotto answerLotto = new AnswerLotto(inputLottoAnswerNumber(), inputBonusNumber());
        return answerLotto;
    }

    private int getNumberOfLotto(int money){
        return money / 1000;
    }


    private void printWinningInformation(Map<WinningRank, Integer> winningDetails) {
        outputView.printWinningDetails(winningDetails);
     }
}
