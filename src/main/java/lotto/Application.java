package lotto;

import lotto.domain.LotteryMachine;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        LotteryMachine lotteryMachine = new LotteryMachine();

        try {
            user.purchaseLottery(lotteryMachine);

            lotteryMachine.drawLottery();
            user.checkResult(lotteryMachine);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
