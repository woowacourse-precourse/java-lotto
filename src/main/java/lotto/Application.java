package lotto;

import lotto.controller.ExceptionHandler;
import lotto.controller.HostController;
import lotto.controller.LottoController;
import lotto.controller.UserController;
import lotto.model.Prize;

public class Application {
    public static void main(String[] args) {
        LottoController lottoCtrl = new LottoController();
        UserController userCtrl = new UserController();
        HostController hostCtrl = new HostController();
        ExceptionHandler excHandler = new ExceptionHandler();

        try{
            userCtrl.purchaseLottery(lottoCtrl);

            hostCtrl.makeWinning();

            userCtrl.updateWinningHistory();

            userCtrl.lotteryOfWinners(Prize.getAllOfMessage());
        }
        catch(IllegalArgumentException e){
            excHandler.printErrorMessage(e);
        }

    }
}
