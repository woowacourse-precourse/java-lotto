package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Shop shop = Shop.getInstance();
        LotteryMachine lotteryMachine = LotteryMachine.getInstance();
        Award award = Award.getInstance();

        try {
            List<Lotto> myLotteries = shop.saleLottery();
            lotteryMachine.setWinning();
            award.compileStatistics(myLotteries);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
