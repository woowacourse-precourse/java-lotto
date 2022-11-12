package lotto;

import lotto.validator.Validator;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private static final int UNIT_PRICE = 1000;
    private static final String PURCHASE_COMMENT = "개를 구매했습니다.";

    private final LottoView view;
    private int count;
    private List<Lotto> tickets;

    public Ticket(int count, List<Lotto> tickets, LottoView view) {
        this.view = view;
        this.count = count;
        this.tickets = tickets;
    }

    public static Ticket purchase(int money) {
        List<Lotto> tickets = new ArrayList<>();
        int count = money / UNIT_PRICE;

        for (int index = 0; index < count; index++) {
            tickets.add(Lotto.createLottoNumbers());
        }

        return new Ticket(count, tickets, new LottoView(new Validator()));
    }

    public void printTickets() {
        view.printBlankLine();
        view.printMessage(String.valueOf(count) + PURCHASE_COMMENT);

        for (Lotto ticket : tickets) {
            view.printMessage(ticket.toString());
        }
    }
}
