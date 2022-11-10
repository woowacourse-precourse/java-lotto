package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {

    public static final int PRICE = 1000;

    private final List<Lotto> lottoTickets;

    public Tickets(int amount) {
        lottoTickets = new ArrayList<>();
        createTickets(amount);
    }

    private void createTickets(int amount) {
        int count = amount / PRICE;
        for (int number = 0; number < count; number++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumbers());
            lottoTickets.add(lotto);
        }
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
