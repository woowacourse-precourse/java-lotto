package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class Tickets {
    private final List<List<Integer>> tickets;

    public Tickets(Integer purchasePrice) {
        Integer purchaseQuantity = purchasePrice / UNIT_PRICE;
        tickets = new ArrayList<>();

        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(generate());
            tickets.add(lotto.getNumbers());
        }
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    private List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        START_NUMBER_INCLUSIVE,
                        END_NUMBER_INCLUSIVE,
                        LOTTO_SIZE
                ));
        Collections.sort(numbers);
        return numbers;
    }
}
