package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomUtil;
import lotto.util.constants.LottoConstants;

public class LottoMachine {
    private int purchaseAmount;
    private int lottoTicketCount;
    private List<Lotto> lottoTickets;

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public LottoMachine(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        computeLottoTicketsCount();
        publishLottoTickets();
    }

    private void computeLottoTicketsCount() {
        this.lottoTicketCount = purchaseAmount / LottoConstants.LOTTO_TICKET_PRICE;
    }

    public void publishLottoTickets() {
        lottoTickets = new ArrayList<>();
        for (int ticketCount = 0; ticketCount < lottoTicketCount; ticketCount++) {
            Lotto lottoTicket = createLottoTicket();
            lottoTickets.add(lottoTicket);
        }

    }

    public Lotto createLottoTicket() {
        RandomUtil lottoRandom = new RandomUtil();
        return new Lotto(lottoRandom.pickNumbers());
    }

}
