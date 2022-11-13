package lotto.ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public List<String> getLottoTickets() {
    	List<String> ticketsList = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            ticketsList.add(lottoTicket.getLottoNumbers().toString());
        }
        return ticketsList;
    }
    
}
