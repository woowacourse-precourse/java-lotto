package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Shop shop = Shop.getInstance();
        LotteryMachine lotteryMachine = LotteryMachine.getInstance();

        shop.purchaseLottery();
        lotteryMachine.setWinningLottery();
        lotteryMachine.setBonus();
    }
}
