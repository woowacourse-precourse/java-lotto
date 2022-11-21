package lotto;

import lotto.controller.ExceptionHandler;
import lotto.controller.HostController;
import lotto.controller.LottoController;
import lotto.controller.UserController;
import lotto.model.Prize;

public class Application {
    static LottoController lottoCtrl = new LottoController();
    static UserController userCtrl = new UserController();
    static HostController hostCtrl = new HostController();
    static ExceptionHandler excHandler = new ExceptionHandler();
    public static void main(String[] args) {

        try {
            buy();
            draw();
            prize();

        } catch (IllegalArgumentException e) {
            excHandler.printErrorMessage(e);
        }
    }

    public static void buy(){
        userCtrl.purchaseLottery(lottoCtrl);
    }
    public static void draw(){
        hostCtrl.makeWinning();
    }

    public static void prize(){
        userCtrl.updateWinningHistory();

        userCtrl.lotteryOfWinners(Prize.getAllOfMessage());
    }
}
