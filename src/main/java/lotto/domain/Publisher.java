package lotto.domain;

import java.util.List;
import java.util.ArrayList;

public class Publisher {

    private static final int TICKET_PRICE = 1000;
    private final long purchaseAmount;
    private final long ticketQuantity;
    private final Generator generator;
    private final List<Lotto> lotteries;

    public Publisher(long purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.ticketQuantity = purchaseAmount / TICKET_PRICE;
        this.generator = new Generator();
        this.lotteries = issueLotto();
    }


    public List<Lotto> getLotteries() {
        return lotteries;
    }

    private List<Lotto> issueLotto() {
        List<Lotto> lotteries = new ArrayList<Lotto>();
        while (lotteries.size() < ticketQuantity) {
            List<Integer> numbers = generator.createLottoNumbers();
            lotteries.add(new Lotto(numbers));
        }
        return lotteries;
    }

    private void validate(long purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }
}
