package lotto.view;

import java.util.List;
import lotto.model.LottoTicketsStorage;

public class IssuedTicketsPrinter {

    public void printIssuedTickets(LottoTicketsStorage lottoTicketsStorage) {
        for (List<Integer> ticket : lottoTicketsStorage.getLottoTickets()) {
            System.out.println(ticket);
        }
    }
}
