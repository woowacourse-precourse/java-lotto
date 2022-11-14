package lotto.controlloer;

import static lotto.view.InputView.*;
import static lotto.view.outputView.printLottoGroup;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.NumberGenerator;

public class Controller {

    public void run(){
        buyLotto();
        getAnswerLotto();
    }

    private void buyLotto(){
        NumberGenerator lottogenerator = new NumberGenerator();
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(getNumberOfLotto(inputMoney())));
        printLottoGroup(lottoGroup);
    }

    private void getAnswerLotto(){
        AnswerLotto answerLotto = new AnswerLotto(inputLottoAnswerNumber(), inputBonusNumber());
    }

    private int getNumberOfLotto(int money){
        return money / 1000;
    }

}
