package lotto.model;


public class LottoStore {
    private final int ticketNumber;

    private enum Constants {
        LOTTO_PRICE(1_000);

        private final int value;

        Constants(int value) {
            this.value = value;
        }
    }

    private LottoStore(int budget) {
        this.ticketNumber = calculateTicketNumber(budget);
    }

    public static LottoStore buyTicketsByBudget(int budget) {
        return new LottoStore(budget);
    }

    private int calculateTicketNumber(int budget) {
        return budget / Constants.LOTTO_PRICE.value;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
