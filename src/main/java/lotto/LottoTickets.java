package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static int getLottoTicketsSize() {
        return lottoTickets.size();
    }

}
