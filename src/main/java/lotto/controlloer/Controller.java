package lotto.controlloer;

import static lotto.view.InputView.*;

import lotto.domain.NumberGenerator;

public class Controller {

    public void run(){
        buyLotto();
        getAnswerLotto();
    }

    private void buyLotto(){
        NumberGenerator.generateLotto(getNumberOfLotto(inputMoney()));
    }

    private void getAnswerLotto(){
        inputLottoAnswerNumber();
        inputBonusNumber();
    }

    private int getNumberOfLotto(int money){
        return money / 1000;
    }

}
