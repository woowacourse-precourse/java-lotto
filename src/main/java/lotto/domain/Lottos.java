package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int ticketCount) {
        this.lottos = generateLottoTicketsByCount(ticketCount);
    }

    private List<Lotto> generateLottoTicketsByCount(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(new Lotto(Lotto.generateLottoTicket()));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
