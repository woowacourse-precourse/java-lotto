package lotto;

import lotto.domain.LotteryDrawMachine;

public class Application {
    public static void main(String[] args) {
        LotteryDrawMachine lotteryDrawMachine = new LotteryDrawMachine();
        System.out.println(lotteryDrawMachine.drawLotteryNumbers().toString());
    }
}
