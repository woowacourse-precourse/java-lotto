package lotto;

import lotto.controller.LotteryController;
import lotto.controller.UserController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            UserController.buyLotteryTicket();
            LotteryController.draw();
            UserController.checkLotteryResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
