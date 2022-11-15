package lotto;

public class LotteryTicket {

    private static final int LOTTO_PRICE = 1000;

    public static int buyTickets(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
