package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import lotto.Lotto;

public class Publisher {
    static final int ticketPrice = 1000;
    private int ticketQuantity;
    private List<Lotto> lotteries;

    public Publisher(int purchaseAmount) {
        validate(purchaseAmount);
        this.ticketQuantity = purchaseAmount / ticketPrice;
        this.lotteries = new ArrayList<Lotto>();
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void issueLotto(List<Integer> numbers) throws IllegalArgumentException {
        return;
    }

    public List<Integer> make() {
        Maker maker = new Maker();
        return maker.getResult();
    }

    private void validate(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % ticketPrice != 0) {
            throw new IllegalArgumentException();
        }
    }
}
