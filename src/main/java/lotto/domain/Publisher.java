package lotto.domain;

import java.util.List;
import java.util.ArrayList;

public class Publisher {

    private static final int TICKET_PRICE = 1000;
    private final int purchaseAmount;
    private final int ticketQuantity;
    private final List<Lotto> lotteries;
    private final Generator generator;

    public Publisher(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.ticketQuantity = purchaseAmount / TICKET_PRICE;
        this.lotteries = new ArrayList<Lotto>(ticketQuantity);
        this.generator = new Generator();
    }

    int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    int getTicketQuantity() {
        return ticketQuantity;
    }

    public void issueLotto() {
        while (lotteries.size() < ticketQuantity) {
            List<Integer> numbers = generator.createLottoNumbers();
            lotteries.add(new Lotto(numbers));
        }
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
