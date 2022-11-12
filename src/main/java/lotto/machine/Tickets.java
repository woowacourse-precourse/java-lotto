package lotto.machine;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class Tickets {
    private final List<List<Integer>> tickets;

    public Tickets(Integer purchasePrice) {
        Integer purchaseQuantity = purchasePrice / UNIT_PRICE;
        tickets = new ArrayList<>();

        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(Numbers.generate());
            tickets.add(lotto.getLottoNumbers());
        }
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }
}
