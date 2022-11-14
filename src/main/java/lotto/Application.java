package lotto;

import lotto.domain.LotteryMachine;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        LotteryMachine lotteryMachine = new LotteryMachine();

        user.purchaseLottery(lotteryMachine);

        lotteryMachine.drawLottery();
        lotteryMachine.showResult(user);
        lotteryMachine.calculateTotalPrize(user);
        lotteryMachine.calculateRateOfReturn(user);
    }
}
