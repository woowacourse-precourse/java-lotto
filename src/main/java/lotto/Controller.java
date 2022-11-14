package lotto;

import static lotto.InputView.*;
import static lotto.NumberGenerator.*;

public class Controller {

    public void run(){
        buyLotto();
        getAnswerLotto();
    }

    private static void buyLotto(){
        generateLotto(getNumberOfLotto(inputMoney()));
    }

    private static void getAnswerLotto(){
        inputLottoAnswerNumber();
        inputBonusNumber();
    }

    private static int getNumberOfLotto(int money){
        return money / 1000;
    }

}
