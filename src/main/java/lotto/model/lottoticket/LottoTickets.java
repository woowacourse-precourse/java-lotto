package lotto.model.lottoticket;

import java.util.List;
import java.util.ArrayList;

import lotto.model.lottostatistics.Ranking;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottoTickets.add(lotto);
    }

    public long getTicketCounts() {
        return lottoTickets.size();
    }

    public List<Ranking> compareWith(LottoWinningNumber lottoWinningNumber) {
        List<Ranking> ranks = new ArrayList<>();

        for (Lotto lotto : lottoTickets) {
            Ranking rank = lottoWinningNumber.calculateWith(lotto);
            ranks.add(rank);
        }

        return ranks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoTickets.forEach(lotto -> stringBuilder.append(lotto.toString())
                .append("\n"));
        return stringBuilder.toString();
    }
}
