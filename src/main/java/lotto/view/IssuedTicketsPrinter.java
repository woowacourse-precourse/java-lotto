package lotto.view;

import java.util.List;
import lotto.model.LottoStorage;

public class IssuedTicketsPrinter {

    public void printIssuedTickets(LottoStorage lottoTicketsStorage) {
        for (List<Integer> ticket : lottoTicketsStorage.getLottoTickets()) {
            System.out.println(ticket);
        }
    }
}
