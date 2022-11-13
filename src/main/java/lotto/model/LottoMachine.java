package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.constants.LottoConstants;

public class LottoMachine {
    public int computeLottoTicketsCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_TICKET_PRICE;
    }

    public List<Lotto> publishLottoTickets(int countLottoTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int ticketCount = 0; ticketCount < countLottoTickets; ticketCount++) {
            Lotto lottoTicket = createLottoTicket();
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    public Lotto createLottoTicket() {
        LottoRandom lottoRandom = new LottoRandom();
        return new Lotto(lottoRandom.pickNumbers());
    }
}
