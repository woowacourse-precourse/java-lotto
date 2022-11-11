package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Shop shop = Shop.getInstance();
        LotteryMachine lotteryMachine = LotteryMachine.getInstance();
        Award award = Award.getInstance();

        List<Lotto> myLotteries = shop.purchaseLottery();
        lotteryMachine.setWinning();
        award.compileStatistics(myLotteries);
    }
}
