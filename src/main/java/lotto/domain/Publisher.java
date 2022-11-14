package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {
    static final int TICKET_PRICE = 1000;
    private final int ticketQuantity;
    private Map<Lotto, Bonus> lotteries;

    public Publisher(int purchaseAmount) {
        validate(purchaseAmount);
        this.ticketQuantity = purchaseAmount / TICKET_PRICE;
        this.lotteries = new HashMap<Lotto, Bonus>(ticketQuantity);
    }

    public Map<Lotto, Bonus> getLotteries() {
        return lotteries;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void issueLotto(List<Integer> numbers, int bonusNumber) {
        lotteries.put(new Lotto(numbers), new Bonus(bonusNumber));
    }

    public List<Integer> make() {
        Maker maker = new Maker();
        return maker.getResult();
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
