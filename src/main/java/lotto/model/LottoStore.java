package lotto.model;


import static lotto.util.Constants.LOTTO_PRICE;

public class LottoStore {
    private final int ticketNumber;


    private LottoStore(int budget) {
        this.ticketNumber = calculateTicketNumber(budget);
    }

    public static LottoStore buyTicketsByBudget(int budget) {
        return new LottoStore(budget);
    }

    private int calculateTicketNumber(int budget) {
        return budget / LOTTO_PRICE;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
