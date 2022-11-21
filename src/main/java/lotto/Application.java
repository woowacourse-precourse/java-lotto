package lotto;

import lotto.controller.LotteryController;
import lotto.exception.IllegalArgumentException;

public class Application {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        try{
            lotteryController.runLottoMatch();
        } catch (IllegalArgumentException exception){

        }
    }
}
