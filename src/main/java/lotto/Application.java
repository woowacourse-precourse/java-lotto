package lotto;

import lotto.controller.LottoHandler;
import lotto.view.Print;

public class Application {
    public static void main(String[] args) {
        try {
            LottoHandler lottoHandler = new LottoHandler();
            lottoHandler.sellLotto();
            lottoHandler.pickWinningNumber();
            lottoHandler.pickBonusNumber();
            lottoHandler.calculateResult();
        } catch(Exception e){
            Print.printExceptionMessage(e);
        }
    }
}
