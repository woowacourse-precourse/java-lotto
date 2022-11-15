package lotto;

import controller.LotteryController;

public class Application {
    public static void main(String[] args) {
        LotteryController lotteryController = LotteryController.create();
        lotteryController.run();
    }
}