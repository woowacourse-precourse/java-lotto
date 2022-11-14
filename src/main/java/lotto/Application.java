package lotto;

import lotto.controller.LotteryStore;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LotteryStore lotteryStore = new LotteryStore();
            lotteryStore.buyLotto();
            lotteryStore.inputWinningNumbers();
            lotteryStore.inputBonusNumber();
            lotteryStore.outputResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
