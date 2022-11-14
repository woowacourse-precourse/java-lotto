package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import lotto.Lotto;

public class Publisher {
    static final int TICKET_PRICE = 1000;
    private int ticketQuantity;
    private Map<Lotto, Integer> lotteries;

    public Publisher(int purchaseAmount) {
        validate(purchaseAmount);
        this.ticketQuantity = purchaseAmount / TICKET_PRICE;
        this.lotteries = new HashMap<Lotto, Integer>(ticketQuantity);
    }

    public Map<Lotto, Integer> getLotteries() {
        return lotteries;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void issueLotto(List<Integer> numbers, int bonusNumber) {
        lotteries.put(new Lotto(numbers), bonusNumber);
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
