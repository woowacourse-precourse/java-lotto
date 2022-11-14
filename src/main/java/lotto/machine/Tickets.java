package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Generator;

import static lotto.Constants.*;

public class Tickets {
    private final List<List<Integer>> tickets;

    public Tickets(Integer purchasePrice) {
        Integer purchaseQuantity = purchasePrice / UNIT_PRICE;
        tickets = new ArrayList<>();

        issue(purchaseQuantity);
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    private void issue(Integer purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(Generator.createRandomNumbers());
            tickets.add(lotto.getNumbers());
        }
    }
}
