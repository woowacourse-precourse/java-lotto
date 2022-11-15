package lotto;

import static lotto.Input.*;
import static lotto.Output.*;


public class LottoGameController {
    private LottoGame lottoGame;
    LottoGameController(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void start(){
        getInput();
        compareResult();
        printStatistic();
    }

    public void getInput(){
        printPurchaseMoneyMessage();
        lottoGame.createLotteGame(getPurchaseMoney());
        lottoGame.printLottos();
        printWinningNumMessage();
        lottoGame.setWinningNumber(getWinningNumber());
        printBonusNumMessage();
        lottoGame.setBonusNumber(getBonusNumber());
    }

    public void compareResult(){
        lottoGame.compare();
    }

    public void printStatistic(){
        lottoGame.printStatistic();
    };
}
