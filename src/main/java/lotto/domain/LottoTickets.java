package lotto.domain;


import java.util.HashSet;
import java.util.Set;

public class LottoTickets {
    private final Set<Lotto> lottoTickets;

    public LottoTickets(Set<Lotto> manualTickets) {
        this.lottoTickets = new HashSet<>(manualTickets);
    }

    public int totalCount() {
        return lottoTickets.size();
    }
}