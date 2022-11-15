package lotto.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final Set<Lotto> lottoTickets;

    public LottoTickets(Set<Lotto> manualTickets) {
        this.lottoTickets = new HashSet<>(manualTickets);
    }

    public int totalCount() {
        return lottoTickets.size();
    }

    public List<Rank> findWinner(lotto.domain.WinningNumbers winningNumbers) {
        List<lotto.domain.Rank> winnerList = new ArrayList<>();
        lottoTickets.forEach((lottoTicket) -> {
            lotto.domain.Rank rank = winningNumbers.getRank(lottoTicket);
            winnerList.add(rank);
        });

        return winnerList;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lottoTicket -> {
            sb.append(lottoTicket.toString());
            sb.append("\n");
        });

        return sb.toString();
    }
}