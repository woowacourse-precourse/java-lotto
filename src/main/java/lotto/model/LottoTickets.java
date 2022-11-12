package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets() {
    }


//    public LottoTickets(final List<Lotto> lottoTickets) {
//        this.lottoTickets.addAll(lottoTickets);
//    }

//    public static LottoTickets of(final List<Lotto> lottoTickets) {
//        return new LottoTickets(lottoTickets);
//    }

    public void addLotto(Lotto lotto) {
        this.lottoTickets.add(lotto);
    }

    public long getTicketCounts() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoTickets.forEach(lotto -> stringBuilder.append(lotto.toString())
            .append("\n"));
        return stringBuilder.toString();
    }
}
