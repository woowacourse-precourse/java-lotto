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
            Lotto lottoTicket = getLottoTicket();
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    public Lotto getLottoTicket() {
        LottoRandom lottoRandom = new LottoRandom();
        Lotto lotto = new Lotto(lottoRandom.pickNumbers());
        return lotto;
    }
}
