package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {

    private static final int PRICE = 1000;

    private final List<Lotto> tickets;

    public Tickets() {
        tickets = new ArrayList<>();
    }

    public void create(int amount) {
        int count = amount / PRICE;
        for (int number = 0; number < count; number++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumbers());
            tickets.add(lotto);
        }
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
