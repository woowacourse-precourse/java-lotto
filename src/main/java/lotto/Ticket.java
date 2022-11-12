package lotto;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private static final int UNIT_PRICE = 1000;
    private int count;
    private List<Lotto> tickets;

    public Ticket(int money) {
        count = money / UNIT_PRICE;
        tickets = new ArrayList<>();
    }

    public void purchase() {
        for (int index = 0; index < count; index++) {
            tickets.add(Lotto.createLottoNumbers());
        }
    }
}
