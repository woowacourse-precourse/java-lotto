package lotto.view;

import java.util.List;
import lotto.model.LottoStorage;

public class IssuedTicketsPrinter {

    public static void printIssuedTickets() {
        for (List<Integer> ticket : LottoStorage.getLottoTickets()) {
            System.out.println(ticket);
        }
    }
}
