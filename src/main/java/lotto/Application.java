package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int ticketAmount = Purchase.buyLotto();
        DrawNumber.generateNumber(ticketAmount);
        DrawNumber.printNumber(ticketAmount);
        LuckyNumber.pickSixNumber();
        LuckyNumber.pickBonusNumber();
        Winning.checkWinning(ticketAmount);
        Winning.printWinningResult();
        Profit.calculateProfit(ticketAmount*1000);
    }
}
