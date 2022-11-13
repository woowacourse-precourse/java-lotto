package lotto;

public class Application {
    public static void main(String[] args) {
        LottoBuyer lottoBuyer = new LottoBuyer();

        UI.printBuyingLotto(lottoBuyer.getCost()/1000, lottoBuyer.getLotteries());

        LottoDraw lottoDraw = new LottoDraw(lottoBuyer);
        lottoDraw.compareLotteries();
        lottoDraw.calculatePrizeMoney();

        UI.printWinningHistory(lottoDraw.getNumberOfMatching(), lottoDraw.calculateProfit());

    }
}
