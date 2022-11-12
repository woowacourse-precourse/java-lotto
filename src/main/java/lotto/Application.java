package lotto;

public class Application {
    public static void main(String[] args) {
        int ticketAmount = Purchase.buyLotto();
        DrawNumber.generateNumber(ticketAmount);
        DrawNumber.printNumber(ticketAmount);
        LuckyNumber.pickSixNumber();
        LuckyNumber.pickBonusNumber();
    }
}
