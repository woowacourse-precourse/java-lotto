package lotto;

import lotto.lotterymachine.controller.LotteryMachineController;

public class Application {
    public static void main(String[] args) {
        LotteryMachineController lotteryMachineController = new LotteryMachineController();
        lotteryMachineController.startGame();
    }
}
