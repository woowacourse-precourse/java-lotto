package lotto;

import lotto.controller.LotteryStore;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LotteryStore lotteryStore = new LotteryStore();
        lotteryStore.buyLotto();
        lotteryStore.inputWinningNumbers();
        lotteryStore.inputBonusNumber();
        lotteryStore.outputResult();
    }
}
