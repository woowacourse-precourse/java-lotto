package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAutomaton;

public class LottoAutomatonRepository extends LottoAutomaton {
    public LottoAutomatonRepository() {
    }

    @Override
    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

    @Override
    public int getQuantity(String amount) {
        return super.getQuantity(amount);
    }

    @Override
    public List<Integer> createNumbers() {
        return super.createNumbers();
    }

    public List<Lotto> createTickets(int quantity) {
        List<Lotto> tickets = new ArrayList<>();
        for (int index = 0; index < quantity; index++) {
            tickets.add(new Lotto(createNumbers()));
        }
        return tickets;
    }
}