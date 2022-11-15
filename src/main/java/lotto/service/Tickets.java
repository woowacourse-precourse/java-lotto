package lotto.service;

import static lotto.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class Tickets {
    private final List<List<Integer>> tickets;
    private final Integer purchaseQuantity;

    public Tickets(Integer purchasePrice) {
        tickets = new ArrayList<>();
        purchaseQuantity = purchasePrice / UNIT_PRICE;
        issueTickets(purchaseQuantity);
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    private void issueTickets(Integer purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            final Lotto lotto = new Lotto(createRandomNumbers());
            tickets.add(lotto.getNumbers());
        }
    }

    private List<Integer> createRandomNumbers() {
        final List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        START_NUMBER_INCLUSIVE,
                        END_NUMBER_INCLUSIVE,
                        LOTTO_SIZE
                ));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
